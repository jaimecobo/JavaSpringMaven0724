package co.jaimecobo.javaspringmaven0724.database.dao;

import co.jaimecobo.javaspringmaven0724.database.entity.VisitedCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface VisitedCityDAO extends JpaRepository<VisitedCity, Long> {
    VisitedCity findByUserIdAndCityId(Integer id, Integer id1);

    VisitedCity findByCityId(VisitedCity visitedCityId);

    @Query(value="SELECT c.id, c.name AS city, c.state_province_department_territory as state, c.country, c.slogan, c.description, c.city_image_url AS image, c.city_web_url AS web " +
            "FROM visited_cities vc, cities c " +
            "WHERE vc.city_id = c.id AND vc.user_id = :id AND city_visited = 1 " +
            "ORDER BY city;",
            nativeQuery = true)
    List<Map<String, Object>> findByUserId(Integer id);


}
