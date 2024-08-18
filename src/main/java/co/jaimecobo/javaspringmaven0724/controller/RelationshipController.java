package co.jaimecobo.javaspringmaven0724.controller;

import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.Relationship;
import co.jaimecobo.javaspringmaven0724.database.entity.User;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedUserUtilities;
import co.jaimecobo.javaspringmaven0724.service.RelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/relationship")
public class RelationshipController {

    @Autowired
    private RelationshipService relationshipService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;


    @GetMapping("/followedOrNot")
    public ModelAndView createUser(@RequestParam Integer status, @RequestParam Integer userId) {
        ModelAndView response = new ModelAndView("user/user");
        User user = userDAO.findById(userId);
        Relationship relationship = relationshipService.createRelationship(status, user);
        response.addObject("relationshipKey", relationship);
        response.setViewName("redirect:/user/user/" + authenticatedUserUtilities.getCurrentUser().getId());
        return response;
    }

}