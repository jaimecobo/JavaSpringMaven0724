package co.jaimecobo.javaspringmaven0724;

import co.jaimecobo.javaspringmaven0724.database.dao.CityDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class CityDAOTest {

    @Autowired
    private CityDAO cityDAO;

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
//        Assertions.assertTrue(cities.size() == 6);
        Assertions.assertEquals(6, cities.size());

    }


    @ParameterizedTest
    @CsvSource({"1, Austin", "2, Denver", "3, Boulder", "4, Houston"})
    public void findCityById(Integer id, String cityName){
        City city = cityDAO.findById(id);
        assert city.getName().equals(cityName);

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

        cityDAO.delete(given);
        Assertions.assertNull(cityDAO.findById(actual.getId()));

    }

}