package lv.javaguru.travel.insurance.core.valids;

import lv.javaguru.travel.insurance.validation.v1.TravelCalculatePremiumRequestV1;
import lv.javaguru.travel.insurance.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class EmptyPersonBirthDateValidation extends TravelRequestValidationImpl {

    @Autowired private ValidationErrorFactory errorFactory;

    @Override
    public Optional<ValidationError> validate(TravelCalculatePremiumRequestV1 request) {
        return (personBirthDateIsNull(request))
                ? Optional.of(errorFactory.buildError("ERROR_CODE_11"))
                : Optional.empty();
    }

    private boolean personBirthDateIsNull(TravelCalculatePremiumRequestV1 request) {
        return request.getPersonBirthDate() == null;
    }

}
