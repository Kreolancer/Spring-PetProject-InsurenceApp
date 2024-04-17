package travel.insurance.core.underwriting;

import travel.insurance.dto.TravelCalculatePremiumRequest;

import java.math.BigDecimal;

public interface TravelRiskPremiumCalculator {
    BigDecimal calculatePremium(TravelCalculatePremiumRequest request);
    String getRiskIc();
}
