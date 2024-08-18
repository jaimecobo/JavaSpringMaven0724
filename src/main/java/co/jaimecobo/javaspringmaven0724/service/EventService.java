package co.jaimecobo.javaspringmaven0724.service;

import co.jaimecobo.javaspringmaven0724.database.dao.CityDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.EventDAO;
import co.jaimecobo.javaspringmaven0724.database.dao.UserDAO;
import co.jaimecobo.javaspringmaven0724.database.entity.Event;
import co.jaimecobo.javaspringmaven0724.form.CreateEventFormBean;
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
public class EventService {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private UserDAO userDAO;

    public Event createEvent(CreateEventFormBean form) {
        log.debug(form.toString());
        Event event = eventDAO.findById(form.getEventId());
        if (event == null) {
            event = new Event();
        }
        event.setName(form.getName());
        event.setDescription(form.getDescription());
        event.setOrganizer(userDAO.findById(authenticatedUserUtilities.getCurrentUser().getId()));
        event.setCity(cityDAO.findById(form.getCityId()));
        event.setStartingDate(form.getStartingDate());
        event.setEndingDate(form.getEndingDate());
        event.setEventWebUrl(form.getEventWebUrl());
        event.setEventImageUrl(cityImageFileUpload(form.getFile()));
        event.setCreatedAt(new Date());
        event = eventDAO.save(event);

        return event;

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
        String saveFilename = "./src/main/webapp/pub/images/events/" + file.getOriginalFilename();
        try {
            Files.copy(file.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING);
        } catch ( Exception e ) {
            log.error("Unable to finish reading file", e);
        }
        return "/pub/images/events/" + file.getOriginalFilename();

    }

}