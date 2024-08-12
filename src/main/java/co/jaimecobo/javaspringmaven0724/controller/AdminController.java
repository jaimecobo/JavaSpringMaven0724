package co.jaimecobo.javaspringmaven0724.controller;

import co.jaimecobo.javaspringmaven0724.database.dao.CityDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.EventDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.City;
import co.jaimecobo.javaspringmaven0724.database.entity.Employee;
import co.jaimecobo.javaspringmaven0724.database.entity.Event;
import co.jaimecobo.javaspringmaven0724.database.entity.User;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedEmployeeUtilities;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")           // This annotation can be used here at the class level or directly on a method
public class AdminController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    public AdminController(AuthenticatedUserUtilities authenticatedUserUtilities) {
        this.authenticatedUserUtilities = authenticatedUserUtilities;
    }

//    @Autowired
//    private AuthenticatedEmployeeUtilities authenticatedEmployeeUtilities;
//
//    public AdminController(AuthenticatedEmployeeUtilities authenticatedEmployeeUtilities) {
//        this.authenticatedEmployeeUtilities = authenticatedEmployeeUtilities;
//    }


    //    @PreAuthorize("hasAnyAuthority('ADMIN')")     // This annotation can be used here on the method level or at the class
    @GetMapping("dashboard")
    public ModelAndView dashboard() {
        ModelAndView response = new ModelAndView("admin/dashboard");
        User user  = authenticatedUserUtilities.getCurrentUser();
            log.info(user.toString());
        response.addObject("userKey", user);
        List<User> usersList = userDAO.findAll();
        response.addObject("usersKey", usersList);
        List<Event> eventsList = eventDAO.findAll();
        response.addObject("eventsKey", eventsList);
        List<City> cityList = cityDAO.findAll();
        response.addObject("citiesKey", cityList);
        return response;
    }

}
