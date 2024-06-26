package travel.insurance.core.validation;

import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidateIfCountryEmpty extends TravelRequestValidationImpl{
    @Autowired
    private ValidationErrorFactory validationErrorFactory;

    private boolean containsTravelMedical(TravelCalculatePremiumRequest request) {
        return request.getSelected_risks()!= null
                && request.getSelected_risks().contains("TRAVEL_MEDICAL");
    }

    private boolean countryIsNullOrBlank(TravelCalculatePremiumRequest request) {
        return request.getCountry() == null || request.getCountry().isBlank();
    }
    @Override
    public Optional<ValidationError> validate(TravelCalculatePremiumRequest request) {
        return (containsTravelMedical(request) && countryIsNullOrBlank(request))
                ? Optional.of(validationErrorFactory.createError("ERROR_CODE_10"))
                : Optional.empty();
    }
}
