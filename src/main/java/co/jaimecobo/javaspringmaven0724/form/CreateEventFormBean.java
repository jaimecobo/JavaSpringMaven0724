package co.jaimecobo.javaspringmaven0724.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@ToString
public class CreateEventFormBean {

    private Integer eventId;

    @Length(max = 50, message = "Event name must be less than 50 characters")
    @NotEmpty(message="Event name is required")
    private String name;

    @Length(max = 255, message = "Event description must be less than 255 characters")
    @NotEmpty(message="Event description is required")
    private String description;

    private Integer organizerId;

//    @NotEmpty(message="City is required")
    private Integer cityId;

    @NotEmpty(message = "Starting date is required")
    private String startingDate;


    @NotEmpty(message = "Ending date is required")
    private String endingDate;

    private String eventImageUrl;

    @NotEmpty(message = "Event website URL is required")
    // TO DO = Add validation for unique eventWebUrl
    private String eventWebUrl;

    private Date createdAt;

    private MultipartFile file;

}
