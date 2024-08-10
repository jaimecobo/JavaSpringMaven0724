package co.jaimecobo.javaspringmaven0724;

import co.jaimecobo.javaspringmaven0724.database.dao.CityDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.EventDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.City;
import co.jaimecobo.javaspringmaven0724.database.entity.Event;
import co.jaimecobo.javaspringmaven0724.database.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class EventDAOTest {

    EventDAO eventDAO = new EventDAO() {
        @Override
        public List<Event> findAll(Sort sort) {
            return List.of();
        }

        @Override
        public Page<Event> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Event> S save(S entity) {
            return null;
        }

        @Override
        public <S extends Event> List<S> saveAll(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public Optional<Event> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public List<Event> findAll() {
            return List.of();
        }

        @Override
        public List<Event> findAllById(Iterable<Long> longs) {
            return List.of();
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Event entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Event> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Event> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Event> List<S> saveAllAndFlush(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public void deleteAllInBatch(Iterable<Event> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Event getOne(Long aLong) {
            return null;
        }

        @Override
        public Event getById(Long aLong) {
            return null;
        }

        @Override
        public Event getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Event> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Event> List<S> findAll(Example<S> example) {
            return List.of();
        }

        @Override
        public <S extends Event> List<S> findAll(Example<S> example, Sort sort) {
            return List.of();
        }

        @Override
        public <S extends Event> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Event> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Event> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Event, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }

        @Override
        public Event findById(Integer id) {
            return null;
        }

        @Override
        public List<Event> findByOrganizerId(Integer id) {
            return List.of();
        }

        @Override
        public List<Event> findByNameIgnoreCase(String eventName) {
            return List.of();
        }

        @Override
        public Event findByNameAndCityIdAndStartingDateIgnoreCase(String name, Integer cityId, String startingDate) {
            return null;
        }

        @Override
        public Event findByNameAndStartingDateIgnoreCase(String name, String startingDate) {
            return null;
        }

        @Override
        public List<Event> findByCity(City city) {
            return List.of();
        }
    };

    CityDAO cityDAO = new CityDAO() {
        @Override
        public City findById(Integer id) {
            return null;
        }

        @Override
        public List<City> findByNameIgnoreCase(String name) {
            return List.of();
        }

        @Override
        public City findByNameAndStateProvinceDepartmentTerritoryAndCountryIgnoreCase(String name, String stateProvinceDepartmentTerritory, String country) {
            return null;
        }

        @Override
        public List<City> findAllOrderedByCity() {
            return List.of();
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends City> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends City> List<S> saveAllAndFlush(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public void deleteAllInBatch(Iterable<City> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public City getOne(Long aLong) {
            return null;
        }

        @Override
        public City getById(Long aLong) {
            return null;
        }

        @Override
        public City getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends City> List<S> findAll(Example<S> example) {
            return List.of();
        }

        @Override
        public <S extends City> List<S> findAll(Example<S> example, Sort sort) {
            return List.of();
        }

        @Override
        public <S extends City> List<S> saveAll(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public List<City> findAll() {
            return List.of();
        }

        @Override
        public List<City> findAllById(Iterable<Long> longs) {
            return List.of();
        }

        @Override
        public <S extends City> S save(S entity) {
            return null;
        }

        @Override
        public Optional<City> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(City entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends City> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<City> findAll(Sort sort) {
            return List.of();
        }

        @Override
        public Page<City> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends City> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends City> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends City> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends City> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends City, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

    UserDAO userDAO = new UserDAO() {
        @Override
        public User findById(Integer id) {
            return null;
        }

        @Override
        public User findByUsernameIgnoreCase(String username) {
            return null;
        }

        @Override
        public User findByEmailIgnoreCase(String email) {
            return null;
        }

        @Override
        public User findByBrandNicknameCompanyIgnoreCase(String brandNicknameCompany) {
            return null;
        }

        @Override
        public List<User> findByFirstNameIgnoreCase(String firstName) {
            return List.of();
        }

        @Override
        public List<User> findByCityIgnoreCase(String city) {
            return List.of();
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends User> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public void deleteAllInBatch(Iterable<User> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public User getOne(Long aLong) {
            return null;
        }

        @Override
        public User getById(Long aLong) {
            return null;
        }

        @Override
        public User getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example) {
            return List.of();
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
            return List.of();
        }

        @Override
        public <S extends User> List<S> saveAll(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public List<User> findAll() {
            return List.of();
        }

        @Override
        public List<User> findAllById(Iterable<Long> longs) {
            return List.of();
        }

        @Override
        public <S extends User> S save(S entity) {
            return null;
        }

        @Override
        public Optional<User> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(User entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends User> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<User> findAll(Sort sort) {
            return List.of();
        }

        @Override
        public Page<User> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends User> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };


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
        Assertions.assertTrue(events.size() == 6);
    }


    @Test
    public void createAndDeleteEventTest(){
        // Given
        Event given = new Event();
        given.setName("Test event");
        given.setDescription("Testing event description");
        User user = userDAO.findById(1);
        given.setOrganizer(user);
        City  city = cityDAO.findById(1);
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
        Assertions.assertEquals(given.getOrganizerId(), actual.getOrganizerId());
        Assertions.assertEquals(given.getCityId(), actual.getCityId());
        Assertions.assertEquals(given.getStartingDate(), actual.getStartingDate());
        eventDAO.delete(given);
        Assertions.assertNull(eventDAO.findById(actual.getId()));
    }


}
