package co.jaimecobo.javaspringmaven0724.controller;

import co.jaimecobo.javaspringmaven0724.database.dao.VisitedCityDAO;
import co.jaimecobo.javaspringmaven0724.service.VisitedCityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/visitedcity")
public class VisitedCityController {

    @Autowired
    private VisitedCityDAO visitedCityDAO;
    @Autowired
    private VisitedCityService visitedCityService;

    @GetMapping("/SaveAsVisitedCity")
    public ModelAndView createUser(@RequestParam Integer status, @RequestParam Integer cityId) {
        ModelAndView response = new ModelAndView("city/city");
            response.setViewName("redirect:/city/city/" + visitedCityService.createVisitedCity(status, cityId).getId());
        return response;
    }


}
