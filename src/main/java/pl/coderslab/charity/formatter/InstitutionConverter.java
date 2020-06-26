package pl.coderslab.charity.formatter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.Optional;

@Component
public class InstitutionConverter implements Converter<String, Institution> {

    @Autowired
    private InstitutionRepository institutionRepository;


    @Override
    public Institution convert(String s) {
        Optional<Institution> institution = institutionRepository.findById(Long.parseLong(s));
        return institution.orElse(null);
    }
}
