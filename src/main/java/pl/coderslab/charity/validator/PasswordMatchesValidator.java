package pl.coderslab.charity.validator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import pl.coderslab.charity.domain.dto.UserDto;
import pl.coderslab.charity.domain.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
  implements ConstraintValidator<pl.coderslab.charity.validator.PasswordMatches, Object> {

    private String firstField;
    private String secondField;

    @Override
    public void initialize(pl.coderslab.charity.validator.PasswordMatches constraintAnnotation) {

        firstField = constraintAnnotation.first();
        secondField = constraintAnnotation.second();
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){

        Object fieldValue = new BeanWrapperImpl(obj)
                .getPropertyValue(firstField);
        Object fieldMatchValue = new BeanWrapperImpl(obj)
                .getPropertyValue(secondField);

        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }

//        UserDto user = (UserDto) obj;
//        return user.getPassword().equals(user.getMatchingPassword());
    }     
}