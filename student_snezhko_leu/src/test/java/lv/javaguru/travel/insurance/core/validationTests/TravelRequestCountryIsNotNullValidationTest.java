package lv.javaguru.travel.insurance.core.validationTests;


import lv.javaguru.travel.insurance.core.ValidationError;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.rest.validation.TravelRequestCountryIsNotNullValidation;
import lv.javaguru.travel.insurance.rest.validation.ValidationErrorFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class TravelRequestCountryIsNotNullValidationTest {
    @InjectMocks
    private TravelRequestCountryIsNotNullValidation validator = new TravelRequestCountryIsNotNullValidation();

    @Mock
    private ValidationErrorFactory errorFactory = mock(ValidationErrorFactory.class);

    private TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
    public static boolean isEqual(ValidationError e1, ValidationError e2) {
        return e1.getErrorCode().equals(e2.getErrorCode()) && e1.getDescription().equals(e2.getDescription());
    }

    @Test
    public void TravelCalculatePremiumRequestValidatorCountryNotNullTest() {
        List<String> risks = new ArrayList<>();
        risks.add("TRAVEL_MEDICAL");

        when(request.getPersonFirstName()).thenReturn("First Name");
        when(request.getPersonLastName()).thenReturn("Last Name");
        when(request.getAgreementDateFrom()).thenReturn(Date.valueOf("2026-05-03"));
        when(request.getAgreementDateTo()).thenReturn(Date.valueOf("2026-10-03"));
        when(request.getSelected_risks()).thenReturn(risks);
        when(request.getCountry()).thenReturn(null);


        String errorCode = "ERROR_CODE_10";
        String description = "Field country is empty!";

        when(errorFactory.buildError(errorCode)).thenReturn(new ValidationError(errorCode, description));
        ReflectionTestUtils.setField(validator, "errorFactory", errorFactory);

        Optional<ValidationError> error = validator.validate(request);
        assertTrue("",isEqual(error.get(), new ValidationError(errorCode, description)));
    }

    @Test
    public void TravelCalculatePremiumRequestValidatorCountryNotEmptyTest() {
        List<String> risks = new ArrayList<>();
        risks.add("TRAVEL_MEDICAL");

        when(request.getPersonFirstName()).thenReturn("First Name");
        when(request.getPersonLastName()).thenReturn("Last Name");
        when(request.getAgreementDateFrom()).thenReturn(Date.valueOf("2026-05-03"));
        when(request.getAgreementDateTo()).thenReturn(Date.valueOf("2026-10-03"));
        when(request.getSelected_risks()).thenReturn(risks);
        when(request.getCountry()).thenReturn("");


        String errorCode = "ERROR_CODE_10";
        String description = "Field country is empty!";

        when(errorFactory.buildError(errorCode)).thenReturn(new ValidationError(errorCode, description));
        ReflectionTestUtils.setField(validator, "errorFactory", errorFactory);

        Optional<ValidationError> error = validator.validate(request);
        assertTrue("",isEqual(error.get(), new ValidationError(errorCode, description)));
    }
}
