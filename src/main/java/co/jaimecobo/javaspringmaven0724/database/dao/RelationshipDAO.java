package co.jaimecobo.javaspringmaven0724.database.dao;

import co.jaimecobo.javaspringmaven0724.database.entity.Relationship;
import co.jaimecobo.javaspringmaven0724.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RelationshipDAO extends JpaRepository<Relationship, Long> {
    Relationship findById(Integer id);

@Query(value="SELECT u.id, u.username, u.first_name AS firstname, u.last_name AS lastname, u.username, u.email, u.city, u.state, u.country " +
        "FROM users u, relationships r " +
        "WHERE u.id = r.follower_id AND r.followed_id = :id AND r.follower_or_not = 1 " +
        "ORDER BY firstname, lastname;",
        nativeQuery = true)
    List<Map<String, Object>> getUserFollowers(Integer id);
//    List<Map<String, Object>> findByFollowedId(Integer id);

    @Query(value="SELECT u.id, u.username, u.first_name AS firstname, u.last_name AS lastname, u.username, u.email, u.city, u.state, u.country " +
            "FROM users u, relationships r " +
            "WHERE u.id = r.followed_id AND r.follower_id = :id AND r.follower_or_not = 1 " +
            "ORDER BY firstname, lastname;",
            nativeQuery = true)
    List<Map<String, Object>> getWhoUserFollows(Integer id);

//    Relationship findByFollowerIdAndFollowedId(Integer id, Integer cityId);
    Relationship findByFollowerIdAndFollowedId(User follower, User followed);

//    List<Map<String, Object>> findByFollowerId(Integer id);
}
