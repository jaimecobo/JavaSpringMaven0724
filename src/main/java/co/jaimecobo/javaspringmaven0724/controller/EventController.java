package co.jaimecobo.javaspringmaven0724.controller;

import co.jaimecobo.javaspringmaven0724.database.dao.CityDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.EventDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.City;
import co.jaimecobo.javaspringmaven0724.database.entity.Event;
import co.jaimecobo.javaspringmaven0724.database.entity.User;
import co.jaimecobo.javaspringmaven0724.form.CreateEventFormBean;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedUserUtilities;
import co.jaimecobo.javaspringmaven0724.service.EventService;
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
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;


    @GetMapping("/all-events")
    public ModelAndView allevents() {
        ModelAndView response = new ModelAndView("event/allevents");
        List<Event> eventsList = eventDAO.findAll();
        response.addObject("eventsKey", eventsList);
        return response;

    }

    @GetMapping("/events-by-name")
    public ModelAndView searchEventByName(@RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("event/events-by-name");
        response.addObject("eventKey", name);

        List<Event> eventsList = eventDAO.findByNameIgnoreCase(name);
        response.addObject("eventsKey", eventsList);
        return response;

    }

    @GetMapping("/events-by-city")
    public ModelAndView searchEventByCity(@RequestParam(required = false) Integer cityId) {
        ModelAndView response = new ModelAndView("event/events-by-city");
        City city = cityDAO.findById(cityId);
        response.addObject("cityKey", city);
        List<City> listOfCities = cityDAO.findAllOrderedByCity();
        response.addObject("citiesKey", listOfCities);
        List<Event> listOfEventsFoundInCity = eventDAO.findByCity(city);
        response.addObject("eventsInCityKey", listOfEventsFoundInCity);
        return response;

    }


    @GetMapping({"/event/{id}"})
    public ModelAndView eventById(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("event/event");
        log.debug("The user has selected an event with id = " + id);
        Event event = eventDAO.findById(id);
        response.addObject("eventKey", event);
        User user = userDAO.findById(event.getOrganizerId());
        response.addObject("userKey", user);
        return response;

    }

    @GetMapping("/create-event")
    public ModelAndView createEvent() {
        // Because the page needs the list of cities for the dropdown, we need to add the list of cities to the model
        List<City> ListOfCities = cityDAO.findAllOrderedByCity();
        ModelAndView response = new ModelAndView("event/create-event");
        response.addObject("citiesKey", ListOfCities);
        return response;

    }


    @PostMapping("/submit-event")
    public ModelAndView createEventSubmit(@Valid CreateEventFormBean form, BindingResult bindingResult){
        ModelAndView response = new ModelAndView("event/create-event");

        if ( form.getEventId() == null ) {
            Event event = eventDAO.findByNameAndCityIdAndStartingDateIgnoreCase(form.getName(), form.getCityId(), form.getStartingDate());
//            Event event = eventDAO.findByNameAndStartingDateIgnoreCase(form.getName(), form.getStartingDate());
//            List<Event> events = eventDAO.findByNameIgnoreCase(form.getName());
//            if ( !events.isEmpty() ) {
            if ( event != null ) {
                    bindingResult.rejectValue("name", "name", "This event already exists! Checking from ctrl");
            }
        }

        if(!eventService.validateImage(form.getFile())){
            bindingResult.rejectValue("eventImageUrl", "eventImageUrl", "Make sure your image is a .jpg, .jpeg or .png file and its size isn't larger than 6MB! Checking from ctrl.");
        }

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            // Because the page needs the list of cities for the dropdown, we need to add the list of cities to the model
            List<City> ListOfCities = cityDAO.findAllOrderedByCity();
            response.addObject("citiesKey", ListOfCities);

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            response.setViewName("event/create-event");
        }
        else{
            // This line creates the new event and redirects to their newly created event details page
            response.setViewName("redirect:/event/event/" + eventService.createEvent(form).getId());

        }
        return response;

    }


    @GetMapping({"/edit-event"})
    public ModelAndView editEvent(@RequestParam(required = false) Integer eventId) {
        ModelAndView response = new ModelAndView("event/create-event");
        // Because the page needs the list of cities for the dropdown, we need to add the list of cities to the model
        List<City> ListOfCities = cityDAO.findAllOrderedByCity();
        response.addObject("citiesKey", ListOfCities);

        if(eventId != null) {
            Event event = eventDAO.findById(eventId);
            if(event != null) {
                CreateEventFormBean form = new CreateEventFormBean();
                form.setEventId(event.getId());
                form.setName(event.getName());
                form.setDescription(event.getDescription());
                form.setCityId(event.getCityId());
                form.setOrganizerId(event.getOrganizerId());
                form.setStartingDate(event.getStartingDate());
                form.setEndingDate(event.getEndingDate());
                form.setEventWebUrl(event.getEventWebUrl());
                form.setEventImageUrl(event.getEventImageUrl());
                response.addObject("form", form);
            }
            else {
                response.addObject("errorMessage", "Event was not found!");
            }
        }
        return response;

    }


    @GetMapping({"/delete-event"})
    public ModelAndView deleteEvent(@RequestParam Integer eventId) {
        ModelAndView response = new ModelAndView("admin/dashboard");
        User userAuthenticated = authenticatedUserUtilities.getCurrentUser();
        log.info(userAuthenticated.toString());
        response.addObject("userKey", userAuthenticated);
        Event event = eventDAO.findById(eventId);
        eventDAO.delete(event);

        List<User> usersList = userDAO.findAll();
        response.addObject("usersKey", usersList);
        List<Event> eventsList = eventDAO.findAll();
        response.addObject("eventsKey", eventsList);
        List<City> cityList = cityDAO.findAll();
        response.addObject("citiesKey", cityList);

        return response;

    }

}