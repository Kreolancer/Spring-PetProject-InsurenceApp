package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.ErrorManager;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class TravelRequestDateToNotEmptyValidation implements TravelRequestValidation {

    @Autowired
    private ErrorManager errorManager;

    @Override
    public Optional<ValidationError> check(TravelCalculatePremiumRequest request) {
        return (request.getAgreementDateTo() == null)
                ? Optional.of(new ValidationError(
                    "ERROR_CODE_4",
                    errorManager.getErrorDescription("ERROR_CODE_4")
                ))
                : Optional.empty();
    }
}
