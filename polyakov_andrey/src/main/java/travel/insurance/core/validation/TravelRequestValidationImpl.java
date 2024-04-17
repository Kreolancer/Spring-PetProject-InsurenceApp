package travel.insurance.core.validation;

import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.ValidationError;

import java.util.List;
import java.util.Optional;

abstract class TravelRequestValidationImpl implements TravelRequestValidation{
    @Override
    public Optional<ValidationError> validate(TravelCalculatePremiumRequest request) {
        return Optional.empty();
    }
    @Override
    public List<ValidationError> validateList(TravelCalculatePremiumRequest request) {
        return null;
    }
}
