package co.jaimecobo.javaspringmaven0724.controller;

import co.jaimecobo.javaspringmaven0724.database.dao.CityDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.EventDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.VisitedCityDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.*;
import co.jaimecobo.javaspringmaven0724.form.CreateCityFormBean;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedUserUtilities;
import co.jaimecobo.javaspringmaven0724.service.CityService;
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

@Slf4j
@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private VisitedCityDAO visitedCityDAO;

    @Autowired
    private CityService cityService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;


    @GetMapping("/all-cities")
    public ModelAndView allcities() {
        ModelAndView response = new ModelAndView("city/allcities");
//        response.addObject("city", name);
        List<City> cityList = cityDAO.findAll();
        response.addObject("cities", cityList);

        log.info("############################################################ Logging + Stream + Lambda ############################################################");
        cityList.stream().forEach(city -> {
            log.info("City : " + city.getName());
        });
        log.info("############################################################ Logging + Stream + Lambda ############################################################");

        return response;
    }

    @GetMapping("/search-city")
    public ModelAndView searchCity(@RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("city/searchcity");
        response.addObject("city", name);

        List<City> cityList = cityDAO.findByNameIgnoreCase(name);
        response.addObject("cities", cityList);
        return response;

    }


    @GetMapping({"/city/{id}"})
    public ModelAndView cityById(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("city/city");
        log.debug("The user has selected a city with id = " + id);
        City city = cityDAO.findById(id);
        response.addObject("cityKey", city);
        User user = userDAO.findById(city.getLastEditorUser());
        response.addObject("userKey", user);
        VisitedCity visitedCity = visitedCityDAO.findByUserIdAndCityId(authenticatedUserUtilities.getCurrentUser().getId(), id);
        response.addObject("visitedCityKey", visitedCity);
        return response;

    }

    @GetMapping("/create-city")
    public ModelAndView createCity() {
        return new ModelAndView("city/create-city");
    }

    @PostMapping("/submit-city")
    public ModelAndView createCitySubmit(@Valid CreateCityFormBean form, BindingResult bindingResult){
        ModelAndView response = new ModelAndView("city/create-city");
        if ( form.getCityId() == null ) {
            City c = cityDAO.findByNameAndStateProvinceDepartmentTerritoryAndCountryIgnoreCase(form.getName(), form.getStateProvinceDepartmentTerritory(), form.getCountry());
            if ( c != null ) {
                bindingResult.rejectValue("cityName", "cityName", "This city already exists! Checking from ctrl");
            }
        }
//        log.info("##### The file received is  = " + form.getFile().getOriginalFilename() + " #####");
        if(!cityService.validateImage(form.getFile())){
            bindingResult.rejectValue("cityImageUrl", "cityImageUrl", "Make sure your image is a .jpg, .jpeg or .png file and its size isn't larger than 6MB! Checking from ctrl.");
        }

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            response.setViewName("city/create-city");
        }
        else{
            response.setViewName("redirect:/city/city/" + cityService.createCity(form).getId());
        }
        return response;

    }


    @GetMapping({"/edit-city"})
    public ModelAndView editCity(@RequestParam(required = false) Integer cityId) {
        ModelAndView response = new ModelAndView("city/create-city");
        if(cityId != null) {
            City city = cityDAO.findById(cityId);
            if(city != null) {
                CreateCityFormBean form = new CreateCityFormBean();
                form.setCityId(city.getId());
                form.setName(city.getName());
                form.setStateProvinceDepartmentTerritory(city.getStateProvinceDepartmentTerritory());
                form.setCountry(city.getCountry());
                form.setSlogan(city.getSlogan());
                form.setDescription(city.getDescription());
                form.setCityImageUrl(form.getCityImageUrl());
                form.setCityWebUrl(city.getCityWebUrl());
                form.setLastEditorUser(city.getLastEditorUser());
                form.setEditedDate(city.getEditedDate());

                response.addObject("form", form);
            }
            else {
                response.addObject("errorMessage", "City was not found!");
            }
        }
        return response;

    }


    @GetMapping({"/delete-city"})
    public ModelAndView deleteCity(@RequestParam Integer cityId) {
        ModelAndView response = new ModelAndView("admin/dashboard");
        User userAuthenticated = authenticatedUserUtilities.getCurrentUser();
        log.info(userAuthenticated.toString());
        response.addObject("userKey", userAuthenticated);
        City city = cityDAO.findById(cityId);
        cityDAO.delete(city);

        List<User> usersList = userDAO.findAll();
        response.addObject("usersKey", usersList);
        List<Event> eventsList = eventDAO.findAll();
        response.addObject("eventsKey", eventsList);
        List<City> cityList = cityDAO.findAll();
        response.addObject("citiesKey", cityList);

        return response;

    }

}