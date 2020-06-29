package pl.coderslab.charity.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.domain.User;
import pl.coderslab.charity.security.CurrentUser;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/institutions")
public class InstitutionController {

    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }


    // display all institutions
    @GetMapping("/")
    public String displayInstitutions(Model model) {
        List<Institution> allInstitutions = institutionService.findAll();
        model.addAttribute("institutions", allInstitutions);
        return "institution-list";
    }

    // display form for adding institutions
    @GetMapping("/form")
    public String addInstitution(Model model) {
        model.addAttribute("institution", new Institution());
        return "institution-form";
    }

    //process form add/edit
    @PostMapping("/form")
    public String saveInstitution(@ModelAttribute("institution") @Valid Institution institution, BindingResult result,
                                  Model model) {
        if (!result.hasErrors()) {
            institutionService.saveInstitution(institution);
            return "redirect:/admin/institutions/";
        } else {
            model.addAttribute("failed", "Spróbuj ponownie");
            return "institution-form";
        }
    }


    // confirm-delete an institution
    @GetMapping("/confirm-delete/{id}")
    public String confirmDeleteInstitution(@PathVariable long id, Model model) {
        findInstitution(id, model);
        return "institution-confirm-delete";
    }

    // delete an institution
    @GetMapping("/delete/{id}")
    public String deleteInstitution(@PathVariable long id) {
        institutionService.deleteInstitution(id);
        return "redirect:/admin/institutions/";
    }


    public void findInstitution(long id, Model model) {
        Institution institution = institutionService.findById(id);
        model.addAttribute("institution", institution);
    }

    @ModelAttribute("currentUser")
    public User currentUser(@AuthenticationPrincipal CurrentUser currentUser) {
        return currentUser.getUser();
    }
}
