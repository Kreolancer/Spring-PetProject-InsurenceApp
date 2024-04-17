package travel.insurance.core.validation;

import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidateIfPersonBirthDateEmpty extends TravelRequestValidationImpl{
    @Autowired
    private ValidationErrorFactory validationErrorFactory;

    @Override
    public Optional<ValidationError> validate(TravelCalculatePremiumRequest request) {
        return (request.getPersonBirthDate() == null)
                ? Optional.of(validationErrorFactory.createError("ERROR_CODE_11"))
                : Optional.empty();
    }
}
