package pl.coderslab.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.domain.dto.DonationDto;
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
    public String displayForm(Model model) {
        model.addAttribute("donationDto", new DonationDto());
        return "form";
    }

    @PostMapping("/form")
    public String processForm(@ModelAttribute("donationDto") @Valid DonationDto donationDto,
                              BindingResult result){
        if (!result.hasErrors()){
            donationService.registerUserDonation(donationDto);
            return "form-confirmation";
        }
        return "form";
    }


    @RequestMapping("/form-confirmation")
    public String confirmForm(){
        return "form-confirmation";
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
