package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TravelCalculatorPremiumRequestValidatorTest {

    @Mock
    TravelCalculatorPremiumRequestValidator validator;

    @Test
    void validatePersonFirstName() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn(null);
        Mockito.when(request.getPersonLastName()).thenReturn("Lastname");
        Mockito.when(request.getAgreementDateFrom()).thenReturn(new Date(100000));
        Mockito.when(request.getAgreementDateTo()).thenReturn(new Date(1000000000));
        assertEquals("personFirstName", validator.validate(request).get(0).getField());
        assertEquals("Must not be empty!", validator.validate(request).get(0).getMessage());
    }
    @Test
    void validatePersonLastName() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn("Firstname");
        Mockito.when(request.getPersonLastName()).thenReturn(null);
        Mockito.when(request.getAgreementDateFrom()).thenReturn(new Date(100000));
        Mockito.when(request.getAgreementDateTo()).thenReturn(new Date(1000000000));
        assertEquals("personLastName", validator.validate(request).get(0).getField());
        assertEquals("Must not be empty!", validator.validate(request).get(0).getMessage());
    }
    @Test
    void validateAgreementDateFrom() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn("Firstname");
        Mockito.when(request.getPersonLastName()).thenReturn("Lastname");
        Mockito.when(request.getAgreementDateFrom()).thenReturn(null);
        Mockito.when(request.getAgreementDateTo()).thenReturn(new Date(1000000000));
        assertEquals("agreementDateFrom", validator.validate(request).get(0).getField());
        assertEquals("Must not be empty!", validator.validate(request).get(0).getMessage());
    }
    @Test
    void validateAgreementDateTo() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn("Firstname");
        Mockito.when(request.getPersonLastName()).thenReturn("Lastname");
        Mockito.when(request.getAgreementDateFrom()).thenReturn(new Date(100000));
        Mockito.when(request.getAgreementDateTo()).thenReturn(null);
        assertEquals("agreementDateTo", validator.validate(request).get(0).getField());
        assertEquals("Must not be empty!", validator.validate(request).get(0).getMessage());
    }
    @Test
    void validateAgreementTimeRange() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn("Firstname");
        Mockito.when(request.getPersonLastName()).thenReturn("Lastname");
        Mockito.when(request.getAgreementDateFrom()).thenReturn(new Date(100000));
        Mockito.when(request.getAgreementDateTo()).thenReturn(new Date(100));
        assertEquals("agreementTimeRange", validator.validate(request).get(0).getField());
        assertEquals("Must be positive!", validator.validate(request).get(0).getMessage());
    }




}
