package co.jaimecobo.javaspringmaven0724.database.dao;

import co.jaimecobo.javaspringmaven0724.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    User findById(Integer id);
    User findByUsernameIgnoreCase(String username);
    User findByEmailIgnoreCase(String email);
    User findByBrandNicknameCompanyIgnoreCase(String brandNicknameCompany);
    List<User> findByFirstNameIgnoreCase(String firstName);
    List<User> findByCityIgnoreCase(String city);
}
