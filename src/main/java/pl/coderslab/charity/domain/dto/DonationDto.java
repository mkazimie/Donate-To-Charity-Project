package pl.coderslab.charity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
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

    @NotNull
    @Range(min = 1, max = 10)
    private Integer quantity;

    @NotEmpty
    List<Category> categories;

    @NotNull(message = "* Musisz zaznaczyć jedno pole")
    private Institution institution;

    @NotBlank
    @Size(max = 50)
    private String street;

    @NotBlank
    @Size(max = 50)
    private String city;

    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    private String zipCode;

    @Pattern(regexp = "[0-9]{9}")
    private String phone;

    @NotNull
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;

    @Size(max = 500)
    private String pickUpComment;
}
