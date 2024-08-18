package co.jaimecobo.javaspringmaven0724.service;

import co.jaimecobo.javaspringmaven0724.database.dao.CityDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.City;
import co.jaimecobo.javaspringmaven0724.form.CreateCityFormBean;
import co.jaimecobo.javaspringmaven0724.security.AuthenticatedUserUtilities;
import co.jaimecobo.javaspringmaven0724.validation.CityImageFileValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CityService {

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    public City createCity(CreateCityFormBean form) {
        log.debug(form.toString());
        City city = cityDAO.findById(form.getCityId());
        if (city == null) {
            city = new City();
        }
        city.setName(form.getName());
        city.setStateProvinceDepartmentTerritory(form.getStateProvinceDepartmentTerritory());
        city.setCountry(form.getCountry());
        city.setSlogan(form.getSlogan());
        city.setDescription(form.getDescription());
        city.setCityImageUrl(cityImageFileUpload(form.getFile()));
        city.setCityWebUrl(form.getCityWebUrl());
        city.setLastEditorUser(authenticatedUserUtilities.getCurrentUser().getId());
        city.setCreatedAt(new Date());
        city.setEditedDate(new Date());
        city = cityDAO.save(city);

        return city;

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

    public String cityImageFileUpload(@RequestParam MultipartFile file) {
        String saveFilename = "./src/main/webapp/pub/images/cities/" + file.getOriginalFilename();

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
        return "/pub/images/cities/" + file.getOriginalFilename();

    }

}