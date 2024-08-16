package co.jaimecobo.javaspringmaven0724.database.dao;

import co.jaimecobo.javaspringmaven0724.database.entity.City;
import co.jaimecobo.javaspringmaven0724.database.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventDAO extends JpaRepository<Event, Long> {
    Event findById(Integer id);
    List<Event> findByOrganizerId(Integer id);
    List<Event> findByNameIgnoreCase(String eventName);

    Event findByNameAndCityIdAndStartingDateIgnoreCase(String name, Integer cityId, String startingDate);
    Event findByNameAndStartingDateIgnoreCase(String name, String startingDate);

    List<Event> findByCity(City city);

}