package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.domain.dto.DonationDto;

import java.util.List;

public interface DonationService {

    List<Donation> findAll();

    Donation saveDonation(Donation donation);

    void deleteDonation(long id);

    Donation findById(long id);

    void registerUserDonation(DonationDto donationDto);
}
