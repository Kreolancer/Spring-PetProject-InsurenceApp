package travel.insurance.core.service;

import travel.insurance.core.underwriting.TravelPremiumCalculationResult;
import travel.insurance.core.underwriting.TravelPremiumUnderwriting;
import travel.insurance.core.validation.TravelCalculatePremiumRequestValidator;
import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.TravelCalculatePremiumResponse;
import travel.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {
    @Autowired
    private TravelCalculatePremiumRequestValidator requestValidator;
    @Autowired
    private TravelPremiumUnderwriting underwritingProcess;

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        List<ValidationError> errors = requestValidator.validate(request);
        return errors.isEmpty()
                ? createResponse(request, underwritingProcess.calculatePremium(request))
                : createResponse(errors);
    }

    private TravelCalculatePremiumResponse createResponse(TravelCalculatePremiumRequest request, TravelPremiumCalculationResult premiumCalculationResult) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setPersonBirthDate(request.getPersonBirthDate());
        response.setAgreementDateTo(request.getAgreementDateTo());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setCountry(request.getCountry());
        response.setMedicalRiskLimitLevel(request.getMedicalRiskLimitLevel());
        response.setAgreementPremium(premiumCalculationResult.getTotalPremium());
        response.setRisks(premiumCalculationResult.getRiskPremiumList());
        return response;
    }

    private TravelCalculatePremiumResponse createResponse(List<ValidationError> errors) {
        return new TravelCalculatePremiumResponse(errors);
    }
}
