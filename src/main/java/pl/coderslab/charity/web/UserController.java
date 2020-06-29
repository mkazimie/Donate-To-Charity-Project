package pl.coderslab.charity.web;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.User;
import pl.coderslab.charity.security.CurrentUser;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String homeAuthenticated(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser", currentUser.getUser());
        return "home";
    }

    @GetMapping("/update")
    public String updateProfile(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = userService.findById(currentUser.getUser().getId());
        model.addAttribute("user", user);
        return "user-profile-form";
    }

    @PostMapping("/update")
    public String updateProfileProcess(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                                       @AuthenticationPrincipal CurrentUser currentUser, Model model) {
        if (!bindingResult.hasErrors()) {
            if(user.getPassword().length() > 15){
                model.addAttribute("passwordToLong", "Hasło może mieć maksymalnie 15 znaków");
                return "user-profile-form";
            }
            String email = user.getEmail();
            User byEmail = userService.findByEmail(email);
            if (byEmail != null && byEmail.getId() != user.getId()) {
                model.addAttribute("emailExistsError", "Email istnieje w naszej bazie danych");
                return "user-profile-form";
            }
            userService.saveUser(user);
            currentUser.getUser().setName(user.getName());
            return "redirect:/user/home";
        }
        return "user-profile-form";
    }


}
