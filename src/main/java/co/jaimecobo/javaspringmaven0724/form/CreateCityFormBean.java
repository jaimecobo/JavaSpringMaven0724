package co.jaimecobo.javaspringmaven0724.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@ToString
public class CreateCityFormBean {

    private Integer cityId;

    @Length(max = 50, message = "City name must be less than 50 characters")
    @NotEmpty(message="City name is required")
    private String name;

    @Length(max = 50, message = "State/Province/Department/Territory name must be less than 50 characters")
    @NotEmpty(message="Please enter the state or province or department or territory corresponding to this city")
    private String stateProvinceDepartmentTerritory;

    @Length(max = 50, message = "Country must be less than 50 characters")
    @NotEmpty(message = "Country is required")
    private String country;

    @Length(max = 100, message = "Slogan must be less than 100 characters")
    @NotEmpty(message = "Slogan is required")
    // TO DO = Add validation for unique slogan
    private String slogan;

    @Length(max = 512, message = "Description must be less than 512 characters")
    @NotEmpty(message = "Description is required")
    // TO DO = Add validation for unique description
    private String description;

//    @NotEmpty(message = "City iconic image is required")
    // TO DO = Add validation for unique cityImageUrl
    private String cityImageUrl;

    @NotEmpty(message = "City most representative website URL is required")
    // TO DO = Add validation for unique cityWebUrl
    private String cityWebUrl;

    private Integer LastEditorUser;

    private Date createdAt;

    private Date editedDate;

//    @NotEmpty(message = "City iconic image is required")
    private MultipartFile file;

}