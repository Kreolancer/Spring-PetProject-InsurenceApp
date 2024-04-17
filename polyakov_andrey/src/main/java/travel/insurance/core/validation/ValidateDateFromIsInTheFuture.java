package travel.insurance.core.validation;

import travel.insurance.core.util.DateTimeUtil;
import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
class ValidateDateFromIsInTheFuture extends TravelRequestValidationImpl {
    @Autowired
    private ValidationErrorFactory factory;
    @Autowired
    private DateTimeUtil dateTimeUtil;
    @Override
    public Optional<ValidationError> validate(TravelCalculatePremiumRequest request) {
        Date todayDateAndTime = dateTimeUtil.getTodaysDateAndTime();
        Date agreementDateFrom = request.getAgreementDateFrom();
        return (agreementDateFrom != null && agreementDateFrom.before(todayDateAndTime))
                ? Optional.of(factory.createError("ERROR_CODE_3"))
                : Optional.empty();
    }
}
