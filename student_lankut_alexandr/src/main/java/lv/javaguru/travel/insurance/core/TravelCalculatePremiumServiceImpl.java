package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse premiumResponse = new TravelCalculatePremiumResponse();

        premiumResponse.setPersonFirstName(request.getPersonFirstName());
        premiumResponse.setAgreementDateFrom(request.getAgreementDateFrom());
        premiumResponse.setAgreementDateTo(request.getAgreementDateTo());
        premiumResponse.setPersonLastName(request.getPersonLastName());

        return premiumResponse;
    }

}
