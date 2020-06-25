package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.domain.Institution;

import java.util.List;

public interface InstitutionService {

    List<Institution> findAll();

    Institution saveInstitution(Institution institution);

    void deleteInstitution(long id);

    Institution findById(long id);

    Institution findByName(String name);

}
