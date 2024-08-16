package co.jaimecobo.javaspringmaven0724.service;

import co.jaimecobo.javaspringmaven0724.database.dao.RelationshipDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.Relationship;
import co.jaimecobo.javaspringmaven0724.database.entity.User;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class RelationshipService {

    @Autowired
    private RelationshipDAO relationshipDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    public Relationship createRelationship(Integer status, User user) {
        Relationship relationship = relationshipDAO.findByFollowerIdAndFollowedId(authenticatedUserUtilities.getCurrentUser(), user);
        if (relationship == null) {
            relationship = new Relationship();
        }
        relationship.setFollowerId(authenticatedUserUtilities.getCurrentUser());
        relationship.setFollowedId(user);
        relationship.setFollowerOrNot(status);
        relationship.setCreatedAt(new Date());
        relationship = relationshipDAO.save(relationship);
        return relationship;

    }

}