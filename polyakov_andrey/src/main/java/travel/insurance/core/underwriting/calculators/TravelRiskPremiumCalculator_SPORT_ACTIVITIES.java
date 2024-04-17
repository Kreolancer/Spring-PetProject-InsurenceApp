package travel.insurance.core.underwriting.calculators;

import travel.insurance.core.underwriting.TravelRiskPremiumCalculator;
import travel.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TravelRiskPremiumCalculator_SPORT_ACTIVITIES implements TravelRiskPremiumCalculator {
    @Override
    public String getRiskIc() {
        return "TRAVEL_SPORT_ACTIVITIES";
    }
    @Override
    public BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
        return BigDecimal.ZERO;
    }
}
