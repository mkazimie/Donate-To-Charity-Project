package pl.coderslab.charity.web;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.domain.User;
import pl.coderslab.charity.domain.dto.UserDto;
import pl.coderslab.charity.exception.RecordAlreadyExistsException;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserService userService;

    public HomeController(InstitutionService institutionService, DonationService donationService, UserService userService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> allInstitutions = institutionService.findAll();
        List<Donation> allDonations = donationService.findAll();
        Integer allBags = sumOfBags(allDonations);
        model.addAttribute("allInstitutions", allInstitutions);
        model.addAttribute("allDonations", allDonations.size());
        model.addAttribute("allBags", allBags);
        return "index";
    }


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult, Model model){
        if (!bindingResult.hasErrors()){
            String password = userDto.getPassword();
            String matchingPassword = userDto.getMatchingPassword();
            if (!matchingPassword.equals(password)){
                model.addAttribute("matchError", "* Powtórz hasło");
                return "register";
            }
            try {
                userService.registerUser(userDto);
            } catch (RecordAlreadyExistsException e){
                model.addAttribute("failed", "Podany email istnieje w bazie danych");
                return "register";
            }
            return "redirect:/login";
        }
        return "register";
    }


//    @GetMapping("/create-admin")
//    @ResponseBody
//    public String createAdmin() {
//        User user = new User();
//        user.setName("User");
//        user.setLastName("User");
//        user.setPassword("user1");
//        user.setEmail("user@email.pl");
//        userService.createUser(user);
//        return "Hi admin: " + user.getName();
//    }




    private Integer sumOfBags (List<Donation> donations){
        Integer totalSum = 0;
        for (Donation donation : donations) {
            totalSum += donation.getQuantity();
        }
        return totalSum;
    }



}
