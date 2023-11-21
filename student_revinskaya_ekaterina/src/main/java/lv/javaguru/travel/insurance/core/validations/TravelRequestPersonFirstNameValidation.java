package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.ErrorCodesPropertiesReader;
import lv.javaguru.travel.insurance.core.ValidationErrorFactory;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
class TravelRequestPersonFirstNameValidation implements TravelRequestValidation {
    @Autowired
    private ValidationErrorFactory validationErrorFactory;
    @Override
    public Optional<ValidationError> validate(TravelCalculatePremiumRequest request) {
        return (request.getPersonFirstName() == null || request.getPersonFirstName().isEmpty())
                ? Optional.of(validationErrorFactory.constructError("ERROR_CODE_1"))
                : Optional.empty();
    }
}
