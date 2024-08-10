package co.jaimecobo.javaspringmaven0724;

import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
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

public class UserDAOTest {

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
        Assertions.assertTrue(users.size() == 4);
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
        given.setGender("This is s test, gender undefined");
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
        Assertions.assertEquals(given.getCreatedAt(), actual.getCreatedAt());
        userDAO.delete(given);
        Assertions.assertNull(userDAO.findById(actual.getId()));
    }

}
