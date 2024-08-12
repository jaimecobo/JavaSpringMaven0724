package co.jaimecobo.javaspringmaven0724.form;

import jakarta.validation.constraints.Email;
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
public class CreateUserFormBean {

    private Integer userId;

    @Length(max = 50, message = "Username must be less than 50 characters")
    @NotEmpty(message="Username name is required")
    private String username;

    @Email(message = "Please enter a valid email")
    @NotEmpty(message="Email is required")
    private String email;

    @Length(max = 50, message = "Password must be less than 50 characters")
    @NotEmpty(message = "Password is required")
    private String password;

    @Length(max = 50, message = "Brand/Nickname/Company must be less than 50 characters")
    private String brandNicknameCompany;

    @Length(max = 50, message = "First name must be less than 50 characters")
    @NotEmpty(message="First name is required")
    private String firstName;

    @Length(max = 50, message = "Last name must be less than 50 characters")
    @NotEmpty(message="Last name name is required")
    private String lastName;

    @Length(max = 20, message = "Gender must be less than 20 characters")
    @NotEmpty(message="Gender is required")
    private String gender;

    @Length(max = 11, message = "Phone must be less than 12 characters")
    @NotEmpty(message = "Phone number is required")
    private String phone;

    @Length(max = 50, message = "Address must be less than 50 characters")
    @NotEmpty(message="Address is required")
    private String address;

    @Length(max = 50, message = "City name must be less than 50 characters")
    @NotEmpty(message="City name is required")
    private String city;

    @Length(max = 50, message = "State/Province/Department/Territory name must be less than 50 characters")
    @NotEmpty(message="Please enter the state or province or department or territory corresponding to your city")
    private String state;

    @Length(max = 15, message = "Zip code must be less than 15 characters")
    @NotEmpty(message = "Zip code is required")
    private String zipCode;

    @Length(max = 50, message = "Country must be less than 50 characters")
    @NotEmpty(message = "Country is required")
    private String country;

    private String userImageUrl;

    private Date createdAt;

    private MultipartFile file;

}