package pl.coderslab.charity.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented

public @interface PasswordMatches {

    String message() default "Hasła muszą być identyczne";
    Class<?>[] groups() default {}; 
    Class<? extends Payload>[] payload() default {};

    String first();

    String second();
}
