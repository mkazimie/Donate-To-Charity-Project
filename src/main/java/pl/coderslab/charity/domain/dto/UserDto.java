package pl.coderslab.charity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import pl.coderslab.charity.validator.PasswordMatches;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatches(first = "password", second = "matchingPassword", message = "Hasła muszą być identyczne")
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
    @Length(min = 5, message = "Hasło musi mieć co najmniej 5 znaków")
    private String password;

    @NotBlank
    private String matchingPassword;


}
