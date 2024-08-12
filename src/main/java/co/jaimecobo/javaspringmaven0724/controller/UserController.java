package co.jaimecobo.javaspringmaven0724.controller;

import co.jaimecobo.javaspringmaven0724.database.dao.*;
import co.jaimecobo.javaspringmaven0724.database.entity.*;
import co.jaimecobo.javaspringmaven0724.form.CreateUserFormBean;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedUserUtilities;
import co.jaimecobo.javaspringmaven0724.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private RelationshipDAO relationshipDAO;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private VisitedCityDAO visitedCityDAO;

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private LikeDAO likeDAO;


    @GetMapping("/all-users")
    public ModelAndView allusers() {
        ModelAndView response = new ModelAndView("user/allusers");
        List<User> usersList = userDAO.findAll();
        response.addObject("usersKey", usersList);
        return response;

    }

    @GetMapping("/users-by-name")
    public ModelAndView searchUserByFirstName(@RequestParam(required = false) String firstName) {
        ModelAndView response = new ModelAndView("user/users-by-name");
        response.addObject("firstName", firstName);
        List<User> usersList = userDAO.findByFirstNameIgnoreCase(firstName);
        response.addObject("usersKey", usersList);
        return response;

    }

    @GetMapping("/users-by-city")
    public ModelAndView searchUserByCity(@RequestParam(required = false) String city) {
        ModelAndView response = new ModelAndView("user/users-by-city");
        response.addObject("cityNameKey", city);
        List<User> usersList = userDAO.findByCityIgnoreCase(city);
        response.addObject("usersKey", usersList);
        return response;

    }


    @GetMapping({"/user/{id}"})
    public ModelAndView userById(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("user/user");
//        log.debug("The user has selected an user with id = " + id);
        User user = userDAO.findById(id);
        response.addObject("userKey", user);

        Relationship relationship = relationshipDAO.findByFollowerIdAndFollowedId(authenticatedUserUtilities.getCurrentUser(), user);
        response.addObject("relationshipKey", relationship);

        List<Map<String, Object>> ListOfFollowers = relationshipDAO.getUserFollowers(id);
        response.addObject("ListOfFollowersKey", ListOfFollowers);
        List<Map<String, Object>> ListOfWhoYouFollow = relationshipDAO.getWhoUserFollows(id);
        response.addObject("ListOfWhoYouFollowKey", ListOfWhoYouFollow);
        //TO DO include table for organized events
        List<Event> organizedEventsList = eventDAO.findByOrganizerId(id);
        response.addObject("organizedEventsKey", organizedEventsList);
        List<Map<String, Object>> listOfVisitedCities = visitedCityDAO.findByUserId(id);
        response.addObject("listOfVisitedCitiesKey", listOfVisitedCities);
        List<Post> listOfPosts = postDAO.findByUserId(id);
        response.addObject("listOfPostsKey", listOfPosts);
        List<Comment> listOfComments = commentDAO.findByUserId(id);
        response.addObject("listOfCommentsKey", listOfComments);
        List<Like> listOfLikes = likeDAO.findByUserId(id);
        response.addObject("listOfLikesKey", listOfLikes);

        return response;
    }



//    @GetMapping("/followers")
//    public ModelAndView searchEmployee(@RequestParam List<Map<String, Object>> ListOfFollowers) {
//        ModelAndView response = new ModelAndView("user/followers");
//        response.addObject("ListOfFollowersKey", ListOfFollowers);
//        return response;
//    }
    @GetMapping("/followers")
    public ModelAndView searchFollowers(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("user/followers");
        List<Map<String, Object>> ListOfFollowers = relationshipDAO.getUserFollowers(id);
        response.addObject("ListOfFollowersKey", ListOfFollowers);
        return response;
    }


    @GetMapping("/whoyoufollow")
    public ModelAndView searchWhoYouFollow(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("user/whoyoufollow");
        List<Map<String, Object>> ListOfWhoYouFollow = relationshipDAO.getWhoUserFollows(id);
        response.addObject("ListOfWhoYouFollowKey", ListOfWhoYouFollow);
        return response;
    }


    @GetMapping("/create-user")
    public ModelAndView createUser() {
        return new ModelAndView("user/create-user");
    }


    @PostMapping("/submit-user")
    public ModelAndView createUserSubmit(HttpSession session, @Valid CreateUserFormBean form, BindingResult bindingResult){
        ModelAndView response = new ModelAndView("user/create-user");

        if ( form.getUserId() == null ) {
            User userByUsername = userDAO.findByUsernameIgnoreCase(form.getUsername());
            if ( userByUsername != null ) {
                bindingResult.rejectValue("username", "username", "Try with a different username. Checking from ctrl");
            }

            User userByEmail = userDAO.findByEmailIgnoreCase(form.getEmail());
            if ( userByEmail != null ) {
                bindingResult.rejectValue("email", "email", "Try with a different email. Checking from ctrl");
            }

            User userByBrandNicknameCompany = userDAO.findByBrandNicknameCompanyIgnoreCase(form.getBrandNicknameCompany());
            if ( userByBrandNicknameCompany != null ) {
                bindingResult.rejectValue("brandNicknameCompany", "brandNicknameCompany", "Try with a different Brand/Nickname/Company. Checking from ctrl");
            }

        }

        if(!userService.validateImage(form.getFile())){
            bindingResult.rejectValue("userImageUrl", "userImageUrl", "Make sure your image is a .jpg, .jpeg or .png file and its size isn't larger than 6MB! Checking from ctrl.");
        }

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            response.setViewName("user/create-user");
        }
        else{
            // This line was creating the new employee and redirecting to their new create employee details page
//            response.setViewName("redirect:/user/user/" + userService.createUser(form).getId());

            // These to lines instead of the line above, is creating the new employee and logging in the employee automatically
            userService.createUser(form);
            authenticatedUserUtilities.manualAuthentication(session, form.getEmail(), form.getPassword());
        }
        return response;

    }


    @GetMapping({"/edit-user"})
    public ModelAndView editUser(@RequestParam(required = false) Integer userId) {
        ModelAndView response = new ModelAndView("user/create-user");
        if(userId != null) {
            User user = userDAO.findById(userId);
            if(user != null) {
                CreateUserFormBean form = new CreateUserFormBean();
                form.setUserId(user.getId());
                form.setUsername(user.getUsername());
                form.setEmail(user.getEmail());
                form.setPassword(user.getPassword());
                form.setBrandNicknameCompany(user.getBrandNicknameCompany());
                form.setFirstName(user.getFirstName());
                form.setLastName(user.getLastName());
                form.setGender(user.getGender());
                form.setPhone(user.getPhone());
                form.setAddress(user.getAddress());
                form.setCity(user.getCity());
                form.setState(user.getState());
                form.setZipCode(user.getZipCode());
                form.setCountry(user.getCountry());
                form.setUserImageUrl(user.getUserImageUrl());
                response.addObject("form", form);
            }
            else {
                response.addObject("errorMessage", "User was not found!");
            }
        }
        return response;

    }


    @GetMapping({"/delete-user"})
    public ModelAndView deleteUser(@RequestParam Integer userId) {
        ModelAndView response = new ModelAndView("admin/dashboard");
        User userAuthenticated = authenticatedUserUtilities.getCurrentUser();
        log.info(userAuthenticated.toString());
        response.addObject("userKey", userAuthenticated);
        User user = userDAO.findById(userId);

        List<UserRole> usersRoleList = userRoleDAO.findByUserId(user.getId());
//        assert !usersRoleList.isEmpty();
//        usersRoleList.stream().forEach(userRole -> {
//            userRoleDAO.delete(userRole);
//        });
        assert !usersRoleList.isEmpty();
        userRoleDAO.deleteAll(usersRoleList);

        userDAO.delete(user);

        List<User> usersList = userDAO.findAll();
        response.addObject("usersKey", usersList);
        List<Event> eventsList = eventDAO.findAll();
        response.addObject("eventsKey", eventsList);
        List<City> cityList = cityDAO.findAll();
        response.addObject("citiesKey", cityList);

        return response;

    }

}
