package lv.javaguru.travel.insurance.core.validations;

import lv.javaguru.travel.insurance.core.validations.AgreementDateFromValidator;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AgreementDateFromValidatorTest {
    @Mock
    private ValidationErrorFactory factory;

    @InjectMocks
    private AgreementDateFromValidator validator;

    @Test
    public void shouldReturnErrorIfAgreementDateFromIsNull() {
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);
        when(request.getAgreementDateFrom()).thenReturn(null);
        ValidationError validationError = mock(ValidationError.class);
        when(factory.buildError("ERROR_CODE_3")).thenReturn(validationError);
        Optional<ValidationError> errorOptional = validator.validateArgs(request);
        assertTrue(errorOptional.isPresent());
        assertSame(errorOptional.get(), validationError);
    }
}
