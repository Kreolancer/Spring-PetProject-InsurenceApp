package lv.javaguru.travel.insurance.core.valids;

import lv.javaguru.travel.insurance.core.repositories.ClassifierValueRepository;
import lv.javaguru.travel.insurance.validation.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class MedicalRiskLimitLevelValidation extends TravelRequestValidationImpl {

    @Value( "${medical.risk.limit.level.enabled:false}" )
    private Boolean medicalRiskLimitLevelEnabled;

    @Autowired private ClassifierValueRepository classifierValueRepository;
    @Autowired private ValidationErrorFactory errorFactory;


    @Override
    public Optional<ValidationError> validate(TravelCalculatePremiumRequest request) {
        return (isMedicalRiskLimitLevelEnabled()
                && containsTravelMedical(request)
                && isMedicalRiskLimitLevelNotBlank(request))
                && !existInDatabase(request.getMedicalRiskLimitLevel())
                ? Optional.of(errorFactory.buildError("ERROR_CODE_14"))
                : Optional.empty();
    }

    private boolean isMedicalRiskLimitLevelEnabled() {
        return medicalRiskLimitLevelEnabled;
    }

    private boolean containsTravelMedical(TravelCalculatePremiumRequest request) {
        return request.getSelected_risks() != null
                && request.getSelected_risks().contains("TRAVEL_MEDICAL");
    }

    private boolean isMedicalRiskLimitLevelNotBlank(TravelCalculatePremiumRequest request) {
        return request.getMedicalRiskLimitLevel() != null && !request.getMedicalRiskLimitLevel().isBlank();
    }

    private boolean existInDatabase(String medicalRiscLimitLevelIc) {
        return classifierValueRepository
                .findByClassifierTitleAndIc("MEDICAL_RISK_LIMIT_LEVEL", medicalRiscLimitLevelIc).isPresent();
    }

}
