package pl.coderslab.charity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
//import pl.coderslab.charity.validator.PasswordMatches;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank
    @Length(min = 2, max = 15)
    private String name;

    @NotBlank
    @Length(min = 2, max = 15)
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 5, max = 15)
    private String password;

    @NotBlank
    private String matchingPassword;


}
