package co.jaimecobo.javaspringmaven0724.database.dao;

import co.jaimecobo.javaspringmaven0724.database.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityDAO extends JpaRepository<City, Long> {
    City findById(Integer id);
    List<City> findByNameIgnoreCase(String name);
    City findByNameAndStateProvinceDepartmentTerritoryAndCountryIgnoreCase(String name, String stateProvinceDepartmentTerritory, String country);

    @Query("SELECT c FROM City c ORDER BY c.name")
    List<City> findAllOrderedByCity();

//    List<City> findAllCities();
}
