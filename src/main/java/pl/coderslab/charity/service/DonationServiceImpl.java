package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.domain.dto.DonationDto;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;

    public DonationServiceImpl(DonationRepository donationRepository, InstitutionRepository institutionRepository, CategoryRepository categoryRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;

    }

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation saveDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public void deleteDonation(long id) {

    }

    @Override
    public Donation findById(long id) {
        Optional<Donation> donation = donationRepository.findById(id);
        return donation.orElseThrow(() -> new NoSuchElementException("No such record in our database"));
    }

    public void registerUserDonation(DonationDto donationDto) {
        Donation donation = new Donation();
        donation.setQuantity(donationDto.getQuantity());
        donation.setInstitution(donationDto.getInstitution());
        donation.setCategories(donationDto.getCategories());
        donation.setCity(donation.getCity());
        donation.setPhone(donation.getPhone());
        donation.setPickUpDate(donationDto.getPickUpDate());
        donation.setPickUpTime(donation.getPickUpTime());
        donation.setPickUpComment(donation.getPickUpComment());
        saveDonation(donation);
    }


}
