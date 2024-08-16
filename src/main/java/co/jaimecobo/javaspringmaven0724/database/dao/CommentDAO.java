package co.jaimecobo.javaspringmaven0724.database.dao;

import co.jaimecobo.javaspringmaven0724.database.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDAO extends JpaRepository<Comment, Long> {
    Comment findById(Integer id);
    List<Comment> findByUserId(Integer id);

}