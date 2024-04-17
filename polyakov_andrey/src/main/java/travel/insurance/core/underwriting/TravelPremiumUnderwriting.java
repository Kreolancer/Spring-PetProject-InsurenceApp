package travel.insurance.core.underwriting;

import travel.insurance.dto.TravelCalculatePremiumRequest;

public interface TravelPremiumUnderwriting {
    TravelPremiumCalculationResult calculatePremium(TravelCalculatePremiumRequest request);
}
