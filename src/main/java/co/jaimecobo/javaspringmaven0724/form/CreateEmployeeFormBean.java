package co.jaimecobo.javaspringmaven0724.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateEmployeeFormBean {

    private Integer employeeId;

    @Length(max = 100, message = "Email must be less than 100 characters")
    @NotEmpty(message="Email is required")
    @Email(message = "This must be a valid email")
    private String email;

//    @Pattern(regexp="^(?:[A-Za-z]{4,}\\s?){2,}[A-Za-z]{4,}$", message = "Full name must include first name, Optional[middle name], and last name")
//    @Pattern(regexp="^(?:[A-Za-z'-]+ ){2,}$", message = "Full name must include first name, Optional[middle name], and last name")
    @Pattern(regexp="\\w+ \\w+ ?\\w+ ?\\w+", message = "Full name must include first name, Optional[middle name], and last name(s)")
    @Length(max = 50, message = "Full name must be less than 50 characters")
    @NotEmpty(message = "Full name is required")
    private String fullName;

    @Length(max = 50, message = "Password must be less than 50 characters")
    @NotEmpty(message = "Password is required")
    private String password;
}