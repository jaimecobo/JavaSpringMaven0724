package co.jaimecobo.javaspringmaven0724;

import co.jaimecobo.javaspringmaven0724.database.dao.CityDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.City;
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

public class CityDAOTest {

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

    @Test
    public void findCityByNameAndStateProvinceDepartmentTerritoryAndCountryIgnoreCase(){
        // Given
        String name = "Boulder";
        String state = "CO";
        String country = "USA";
        // When
        City city = cityDAO.findByNameAndStateProvinceDepartmentTerritoryAndCountryIgnoreCase(name, state, country);
        // Then
        Assertions.assertNotNull(city);
        Assertions.assertEquals(name, city.getName());
        Assertions.assertEquals(state, city.getStateProvinceDepartmentTerritory());
        Assertions.assertEquals(country, city.getCountry());



    }

    @Test
    public void findCityByInvalidNameOrStateProvinceDepartmentTerritoryOrCountryIgnoreCase(){
        // Given
        String name = "Austin   ";
        String state = "CO";
        String country = "USA";
        // When
        City city = cityDAO.findByNameAndStateProvinceDepartmentTerritoryAndCountryIgnoreCase(name, state, country);
        // Then
        Assertions.assertNull(city);

    }


    @Test
    public void findAllCitiesTest() {
        // Given
        // When
        List<City> cities = cityDAO.findAll();
        // Then
        Assertions.assertTrue(cities.size() == 6);
    }


    @Test
    public void createAndDeleteCityTest(){
        // Given
        City given = new City();
        given.setName("Test city name");
        given.setStateProvinceDepartmentTerritory("Testing State/Province/Department/Territory");
        given.setCountry("Testing country");
        given.setSlogan("Testing city slogan");
        given.setDescription("Testing city description");
        given.setCityImageUrl("testing/city-image/url");
        given.setCityWebUrl("htttps://www.junit-testing.test");
        given.setLastEditorUser(0);
        given.setEditedDate(new Date());
        given.setCreatedAt(new Date());

        // When
        cityDAO.save(given);

        // Then
        City actual = cityDAO.findById(given.getId());
        Assertions.assertEquals(given.getName(), actual.getName());
        Assertions.assertEquals(given.getStateProvinceDepartmentTerritory(), actual.getStateProvinceDepartmentTerritory());
        Assertions.assertEquals(given.getCountry(), actual.getCountry());
        Assertions.assertEquals(given.getSlogan(), actual.getSlogan());
        Assertions.assertEquals(given.getDescription(), actual.getDescription());
        Assertions.assertEquals(given.getLastEditorUser(), actual.getLastEditorUser());
        Assertions.assertEquals(given.getCreatedAt(), actual.getCreatedAt());

        cityDAO.delete(given);
        Assertions.assertNull(cityDAO.findById(actual.getId()));
    }

}
