package co.jaimecobo.javaspringmaven0724;

import co.jaimecobo.javaspringmaven0724.database.dao.CityDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.EventDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.City;
import co.jaimecobo.javaspringmaven0724.database.entity.Event;
import co.jaimecobo.javaspringmaven0724.database.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class EventDAOTest {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private UserDAO userDAO;

    @Test
    public void findEventByNameAndCityIdAndStartingDateIgnoreCase(){
        // Given
        String name = "ACL-W1";
        Integer cityId = 1;
        String startingDate = "2024-10-04";
        // When
        Event event = eventDAO.findByNameAndCityIdAndStartingDateIgnoreCase(name, cityId, startingDate);
        // Then
        Assertions.assertNotNull(event);
        Assertions.assertEquals(name, event.getName());
        Assertions.assertEquals(cityId, event.getCityId());
        Assertions.assertEquals(startingDate, event.getStartingDate());

    }

    @Test
    public void findEventByInvalidNameOrCityIdORStartingDateIgnoreCase(){
        // Given
        String name = "ACL-W1";
        Integer cityId = 1;
        String startingDate = "2024-10-10";
        // When
        Event event = eventDAO.findByNameAndCityIdAndStartingDateIgnoreCase(name, cityId, startingDate);
        // Then
        Assertions.assertNull(event);

    }


    @Test
    public void findAllEventsTest() {
        // Given
        // When
        List<Event> events = eventDAO.findAll();
        // Then
//        Assertions.assertTrue(events.size() == 6);
        Assertions.assertEquals(6, events.size());

    }


    @ParameterizedTest
    @CsvSource({"12, 1", "15, 3"})
    public void findEventById(Integer id, Integer cityId){
        Event event = eventDAO.findById(id);
        assert event.getCity().getId().equals(cityId);

    }


    @Test
    public void createAndDeleteEventTest(){
        // Given
        User user = userDAO.findById(1);
        City  city = cityDAO.findById(1);
        Event given = new Event();
        given.setName("Test event");
        given.setDescription("Testing event description");
//        User user = userDAO.findById(1);
        given.setOrganizer(user);
//        City  city = cityDAO.findById(1);
        given.setCity(city);
        given.setStartingDate("2024-12-31");
        given.setEndingDate("2025-01-01");
        given.setEventWebUrl("htttps://www.junit-testing.test");
        given.setEventImageUrl("testing/image/url");
        given.setCreatedAt(new Date());

        // When
        eventDAO.save(given);

        // Then
        Event actual = eventDAO.findById(given.getId());
        Assertions.assertEquals(given.getName(), actual.getName());
        Assertions.assertEquals(given.getStartingDate(), actual.getStartingDate());
        eventDAO.delete(given);
        Assertions.assertNull(eventDAO.findById(actual.getId()));

    }

}