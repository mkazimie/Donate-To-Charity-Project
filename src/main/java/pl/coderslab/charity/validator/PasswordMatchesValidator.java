package pl.coderslab.charity.validator;

import pl.coderslab.charity.domain.dto.UserDto;
import pl.coderslab.charity.domain.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
  implements ConstraintValidator<pl.coderslab.charity.validator.PasswordMatches, Object> {
     
    @Override
    public void initialize(pl.coderslab.charity.validator.PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }     
}