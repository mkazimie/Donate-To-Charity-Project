package pl.coderslab.charity.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.domain.Role;
import pl.coderslab.charity.domain.User;
import pl.coderslab.charity.domain.dto.UserDto;
import pl.coderslab.charity.exception.RecordAlreadyExistsException;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.security.CurrentUser;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserService userService;
    private final RoleRepository roleRepository;

    public HomeController(InstitutionService institutionService, DonationService donationService, UserService userService, RoleRepository roleRepository) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }


    @GetMapping("/")
    public String homeAction(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        List<Institution> allInstitutions = institutionService.findAll();
        List<Donation> allDonations = donationService.findAll();
        Integer allBags = sumOfBags(allDonations);
        model.addAttribute("allInstitutions", allInstitutions);
        model.addAttribute("allDonations", allDonations.size());
        model.addAttribute("allBags", allBags);
        if (currentUser != null){
            model.addAttribute("currentUser", currentUser.getUser());
        }
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


    @GetMapping("/login")
    public String loginForm(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        if (currentUser != null) {
            Set<Role> roles = currentUser.getUser().getRoles();
            if (roles.contains(roleRepository.findByName("ROLE_ADMIN"))){
                return "redirect:/admin/home";
            } else {
                return "redirect:/user/home";
            }
        }
        return "login";
    }




    @GetMapping("/create-admin")
    @ResponseBody
    public String createAdmin() {
        User user = new User();
        user.setName("Admin");
        user.setLastName("Admin");
        user.setPassword("admin");
        user.setEmail("admin@email.pl");
        userService.createUser(user);
        return "Hi admin: " + user.getName();
    }




    private Integer sumOfBags (List<Donation> donations){
        Integer totalSum = 0;
        for (Donation donation : donations) {
            totalSum += donation.getQuantity();
        }
        return totalSum;
    }




}
