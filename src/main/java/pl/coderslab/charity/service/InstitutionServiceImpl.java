package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InstitutionServiceImpl implements InstitutionService{

    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution saveInstitution(Institution institution) {
        return institutionRepository.save(institution);
    }

    @Override
    public void deleteInstitution(long id) {
        institutionRepository.delete(findById(id));

    }

    @Override
    public Institution findById(long id) {
        Optional<Institution> institution = institutionRepository.findById(id);
        return institution.orElseThrow(() -> new NoSuchElementException("No such element in our database"));
    }

    @Override
    public Institution findByName(String name) {
        return institutionRepository.findByName(name);
    }
}
