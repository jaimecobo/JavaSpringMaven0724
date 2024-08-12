package co.jaimecobo.javaspringmaven0724.service;


import co.jaimecobo.javaspringmaven0724.database.dao.CityDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.VisitedCityDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.VisitedCity;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class VisitedCityService {

    @Autowired
    private VisitedCityDAO visitedCityDAO;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;


    public VisitedCity createVisitedCity(Integer status, Integer cityId) {
        VisitedCity visitedCity = visitedCityDAO.findByUserIdAndCityId(authenticatedUserUtilities.getCurrentUser().getId(), cityId);
        if (visitedCity == null) {
            visitedCity = new VisitedCity();
        }
        visitedCity.setUser(authenticatedUserUtilities.getCurrentUser());
        visitedCity.setCity(cityDAO.findById(cityId));
        visitedCity.setCityVisited(status);
        visitedCity.setCreatedAt(new Date());
        visitedCity = visitedCityDAO.save(visitedCity);
        return visitedCity;

    }

}
