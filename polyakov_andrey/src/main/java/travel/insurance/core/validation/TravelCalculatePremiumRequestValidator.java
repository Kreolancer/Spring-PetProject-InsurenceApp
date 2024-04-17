package travel.insurance.core.validation;

import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.ValidationError;

import java.util.List;

public interface TravelCalculatePremiumRequestValidator {
    List<ValidationError> validate(TravelCalculatePremiumRequest request);
}
