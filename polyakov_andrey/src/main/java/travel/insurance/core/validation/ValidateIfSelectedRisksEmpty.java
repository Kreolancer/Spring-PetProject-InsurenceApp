package travel.insurance.core.validation;

import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class ValidateIfSelectedRisksEmpty extends TravelRequestValidationImpl {
    @Autowired
    private ValidationErrorFactory factory;
    @Override
    public Optional<ValidationError> validate(TravelCalculatePremiumRequest request) {
        return (request.getSelected_risks() == null || request.getSelected_risks().isEmpty())
                ? Optional.of(factory.createError("ERROR_CODE_8"))
                : Optional.empty();
    }
}
