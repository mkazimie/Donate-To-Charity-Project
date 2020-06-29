package pl.coderslab.charity.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.domain.User;
import pl.coderslab.charity.domain.dto.DonationDto;
import pl.coderslab.charity.security.CurrentUser;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {

    private final CategoryServiceImpl categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;


    public DonationController(CategoryServiceImpl categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/form")
    public String displayForm(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("donationDto", new DonationDto());
        if (currentUser != null){
            model.addAttribute("currentUser", currentUser.getUser());
        }
        return "donation-form";
    }

    @PostMapping("/form")
    public String processForm(@ModelAttribute("donationDto") @Valid DonationDto donationDto,
                              BindingResult result){
        if (!result.hasErrors()){
            donationService.registerUserDonation(donationDto);
            return "donation-form-confirmation";
        }
        return "donation-form";
    }


    @RequestMapping("/form-confirmation")
    public String confirmForm(){
        return "donation-form-confirmation";
    }


    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }


    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

}
