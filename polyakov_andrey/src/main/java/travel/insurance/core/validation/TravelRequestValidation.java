package travel.insurance.core.validation;

import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.ValidationError;

import java.util.List;
import java.util.Optional;

interface TravelRequestValidation {
    Optional<ValidationError> validate(TravelCalculatePremiumRequest request);

    List<ValidationError> validateList(TravelCalculatePremiumRequest request);
}
