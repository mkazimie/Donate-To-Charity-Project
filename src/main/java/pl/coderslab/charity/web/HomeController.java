package pl.coderslab.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> allInstitutions = institutionRepository.findAll();
        List<Donation> allDonations = donationRepository.findAll();
        Integer allBags = sumOfBags(allDonations);
        model.addAttribute("allInstitutions", allInstitutions);
        model.addAttribute("allDonations", allDonations.size());
        model.addAttribute("allBags", allBags);

        return "index";
    }




    private Integer sumOfBags (List<Donation> donations){
        Integer totalSum = 0;
        for (Donation donation : donations) {
            totalSum += donation.getQuantity();
        }
        return totalSum;
    }



}
