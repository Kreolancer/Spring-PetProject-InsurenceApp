package travel.insurance.core.service;

import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.TravelCalculatePremiumResponse;

public interface TravelCalculatePremiumService {

    TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request);

}
