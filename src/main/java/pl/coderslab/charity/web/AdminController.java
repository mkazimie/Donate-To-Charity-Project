package pl.coderslab.charity.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.security.CurrentUser;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserController userController;

    public AdminController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/home")
    public String homeAdmin(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentUser", currentUser.getUser());
        return "admin-panel";
    }



}

