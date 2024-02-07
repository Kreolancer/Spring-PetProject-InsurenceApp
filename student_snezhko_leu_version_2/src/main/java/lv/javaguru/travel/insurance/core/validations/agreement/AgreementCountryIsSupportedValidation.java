package lv.javaguru.travel.insurance.core.validations.agreement;

import lv.javaguru.travel.insurance.core.api.dto.AgreementDTO;
import lv.javaguru.travel.insurance.core.api.dto.ValidationErrorDTO;
import lv.javaguru.travel.insurance.core.repositories.ClassifierValueRepository;
import lv.javaguru.travel.insurance.core.repositories.CountryDefaultDayRateRepository;
import lv.javaguru.travel.insurance.core.validations.ValidationErrorFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AgreementCountryIsSupportedValidation extends TravelAgreementFieldValidationImpl{
    @Autowired
    private ValidationErrorFactory errorFactory;

    @Autowired
    private ClassifierValueRepository classifierValueRepository;

    @Override
    public Optional<ValidationErrorDTO> validate(AgreementDTO agreement) {
        return !existCountry(agreement.getCountry())
                ? Optional.of(errorFactory.buildError("ERROR_CODE_15"))
                : Optional.empty();
    }

    private boolean existCountry(String countryIc) {
        return classifierValueRepository.findByClassifierTitleAndIc("COUNTRY", countryIc).isPresent();
    }
}
