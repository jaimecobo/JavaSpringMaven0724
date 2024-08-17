package co.jaimecobo.javaspringmaven0724.database.dao;

import co.jaimecobo.javaspringmaven0724.database.entity.Like;
import co.jaimecobo.javaspringmaven0724.database.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeDAO extends JpaRepository<Like, Long> {
    Like findById(Integer id);

    List<Like> findByUserId(Integer id);

}