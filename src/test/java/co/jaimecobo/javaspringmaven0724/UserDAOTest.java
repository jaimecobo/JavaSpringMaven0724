package co.jaimecobo.javaspringmaven0724;

import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
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
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void findUserByFirstNameIgnoreCase(){
        // Given
        String username = "lskywalker";
        // When
        User user = userDAO.findByUsernameIgnoreCase(username);
        // Then
        Assertions.assertNotNull(user);
        Assertions.assertEquals(username, user.getUsername());

    }

    @Test
    public void findUserByInvalidFirstNameIgnoreCase(){
        // Given
        String username = "askywalker";
        // When
        User user = userDAO.findByUsernameIgnoreCase(username);
        // Then
        Assertions.assertNull(user);

    }


    @Test
    public void findAllUsersTest() {
        // Given
        // When
        List<User> users = userDAO.findAll();
        // Then
//        Assertions.assertTrue(users.size() == 4);
        Assertions.assertEquals(4, users.size());

    }



    @ParameterizedTest
    @CsvSource({"1, Austin", "2, Los Angeles"})
    public void findUserById(Integer id, String city){
        User user = userDAO.findById(id);
        assert user.getCity().equals(city);

    }



    @Test
    public void createAndDeleteUserTest(){
        // Given
        User given = new User();
        given.setFirstName("Test first name");
        given.setLastName("Test last name");
        given.setUsername("Test first username");
        given.setEmail("user@test.abc");
        given.setPassword("password12345");
        given.setGender("testing gender");
        given.setPhone("7418529630");
        given.setAddress("741 Seventh St.");
        given.setCity("New York");
        given.setState("NY");
        given.setCountry("USA");
        given.setZipCode("10001");
        given.setUserImageUrl("testing/user-image/url");
        given.setCreatedAt(new Date());

        // When
        userDAO.save(given);

        // Then
        User actual = userDAO.findById(given.getId());
        Assertions.assertEquals(given.getFirstName(), actual.getFirstName());
        Assertions.assertEquals(given.getLastName(), actual.getLastName());
        Assertions.assertEquals(given.getUsername(), actual.getUsername());
        Assertions.assertEquals(given.getEmail(), actual.getEmail());
        Assertions.assertEquals(given.getCity(), actual.getCity());
        Assertions.assertEquals(given.getState(), actual.getState());
        Assertions.assertEquals(given.getCountry(), actual.getCountry());
        userDAO.delete(given);
        Assertions.assertNull(userDAO.findById(actual.getId()));

    }

}