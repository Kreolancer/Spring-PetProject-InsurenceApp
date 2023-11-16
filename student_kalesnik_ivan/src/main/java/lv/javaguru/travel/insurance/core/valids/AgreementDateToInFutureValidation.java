package lv.javaguru.travel.insurance.core.valids;

import lv.javaguru.travel.insurance.core.DateTimeService;
import lv.javaguru.travel.insurance.validation.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public
class AgreementDateToInFutureValidation implements TravelRequestValidation {

    @Autowired
    private DateTimeService dateTimeService;

    @Autowired
    public AgreementDateToInFutureValidation(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }
    @Override
    public Optional<ValidationError> execute(TravelCalculatePremiumRequest request) {
        Date dateTo = request.getAgreementDateTo();
        Date currentDateTime = dateTimeService.getCurrentDateTime();
        return (dateTo != null && dateTo.before(currentDateTime))
                ? Optional.of(new ValidationError("agreementDateTo", "Must be in the future!"))
                : Optional.empty();
    }

}