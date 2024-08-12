package co.jaimecobo.javaspringmaven0724.service;

import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.UserRoleDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.EmployeeRole;
import co.jaimecobo.javaspringmaven0724.database.entity.User;
import co.jaimecobo.javaspringmaven0724.database.entity.UserRole;
import co.jaimecobo.javaspringmaven0724.form.CreateUserFormBean;
import co.jaimecobo.javaspringmaven0724.validation.CityImageFileValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(CreateUserFormBean form) {
        log.debug(form.toString());
        User user = userDAO.findById(form.getUserId());
        if (user == null) {
            user = new User();
        }


        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);
        user.setBrandNicknameCompany(form.getBrandNicknameCompany());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setGender(form.getGender());
        user.setPhone(form.getPhone());
        user.setAddress(form.getAddress());
        user.setCity(form.getCity());
        user.setState(form.getState());
        user.setCountry(form.getCountry());
        user.setZipCode(form.getZipCode());
        user.setUserImageUrl(userImageFileUpload(form.getFile()));
        user.setCreatedAt(new Date());
        user = userDAO.save(user);

        // Creates a user role for the new user
        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        userRole.setUserId(user.getId());
        userRole.setCreateDate(new Date());
        userRoleDAO.save(userRole);

        return user;

    }


    public String userImageFileUpload(@RequestParam MultipartFile file) {
        String saveFilename = "./src/main/webapp/pub/images/users/" + file.getOriginalFilename();

        // this Files.copy is a utility that will read the stream one chunk at a time and write it to a file.
        // first arg is the input stream to read from the uploaded file
        // 2nd is the filename where we want to write the file
        // 3rd says to overwrite if existing.
        try {
            Files.copy(file.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING);
        } catch ( Exception e ) {
            log.error("Unable to finish reading file", e);
        }

        // This is the URL where the image is going to be saved
        return "/pub/images/users/" + file.getOriginalFilename();

    }


    // Validate file
    public boolean validateImage(@RequestParam MultipartFile file){
        String fileName = file.getOriginalFilename();
        long fileSize = file.getSize();
        String fileType = file.getContentType();
        log.debug("The file name is: {}", fileName);
        log.debug("The file size is: {}", fileSize);
        log.debug("The file content type is: {}", fileType);
        CityImageFileValidator cityImageFileValidator = new CityImageFileValidator();
        return cityImageFileValidator.isValidFileSize(file.getSize()) && cityImageFileValidator.isValidFileType(fileName, URLConnection.guessContentTypeFromName(fileName));

    }
}
