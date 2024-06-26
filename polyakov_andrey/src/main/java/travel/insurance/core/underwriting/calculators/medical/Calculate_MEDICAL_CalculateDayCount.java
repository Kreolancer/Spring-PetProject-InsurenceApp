package travel.insurance.core.underwriting.calculators.medical;

import travel.insurance.core.util.DateTimeUtil;
import travel.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class Calculate_MEDICAL_CalculateDayCount {
    @Autowired
    private DateTimeUtil dateTimeUtil;
    BigDecimal calculateDayCount(TravelCalculatePremiumRequest request) {
        var daysBetween = dateTimeUtil.getDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo());
        return new BigDecimal(daysBetween);
    }
}
