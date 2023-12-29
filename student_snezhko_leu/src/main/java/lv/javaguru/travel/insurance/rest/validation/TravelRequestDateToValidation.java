package lv.javaguru.travel.insurance.rest.validation;

import lv.javaguru.travel.insurance.core.ValidationError;
import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.rest.TravelRequestValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Optional;

public class TravelRequestDateToValidation implements TravelRequestValidation {
    /*
    @Autowired

    ValidationErrorsUtil util;
     */
    @Override
    public Optional<ValidationError> validate(TravelCalculatePremiumRequest request) {
//        ValidationErrorsUtil util = new ValidationErrorsUtil();
        ValidationErrorsUtil util;
        try {
            util = new ValidationErrorsUtil();
        }
        catch (IOException e) {
            return Optional.of(new ValidationError("ERROR_CODE_0", "IOException is errorCode.properties!"));//util.buildError("ERROR_CODE_3"));
        }
        if (request.getAgreementDateTo() == null) {
            String errorCode = "ERROR_CODE_5";
            return Optional.of(new ValidationError(errorCode, util.getDescriptionByErrorCode(errorCode)));
        }
        else if (request.getAgreementDateTo().before(request.getAgreementDateFrom())) {
            String errorCode = "ERROR_CODE_6";
            return Optional.of(new ValidationError(errorCode, util.getDescriptionByErrorCode(errorCode)));
        }
        return Optional.empty();
    }
}
