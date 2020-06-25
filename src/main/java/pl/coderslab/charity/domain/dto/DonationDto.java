package pl.coderslab.charity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.domain.Institution;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDto {

    //    @NotBlank
//    @Max(50)
    private Integer quantity;

    //    @NotEmpty
    List<Category> categories;

    //    @NotBlank
//    @Size(max = 50)
    private Institution institution;


    //    @NotBlank
//    @Size(max = 50)
    private String street;

    //    @NotBlank
//    @Size(max = 50)
    private String city;

    //    @NotBlank
//    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    private String zipCode;

    //    @NotBlank
//    @Pattern(regexp = "[1-9]{3}-[0-9]{3}-[0-9]{3}")
    private String phone;

    //    @FutureOrPresent
//    @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    //    @FutureOrPresent
//    @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;

    //    @Size(max = 500)
    private String pickUpComment;
}
