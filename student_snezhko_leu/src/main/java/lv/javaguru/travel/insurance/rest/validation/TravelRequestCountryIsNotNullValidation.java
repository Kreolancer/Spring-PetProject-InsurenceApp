package lv.javaguru.travel.insurance.rest.validation;

import lv.javaguru.travel.insurance.core.ValidationError;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TravelRequestCountryIsNotNullValidation extends TravelRequestValidationImpl{
    @Autowired
    private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationError> validate(TravelCalculatePremiumRequest request) {
        Optional<ValidationError> result = Optional.empty();
        if (request.getSelected_risks() == null || request.getSelected_risks().isEmpty()) {
            return result;
        }
        if (!request.getSelected_risks().contains("TRAVEL_MEDICAL")) {
            return result;
        }
        if (request.getCountry() == null || request.getCountry().isEmpty()) {
            String errorCode = "ERROR_CODE_10";
            result = Optional.of(errorFactory.buildError(errorCode));
        }

        return result;
    }
}