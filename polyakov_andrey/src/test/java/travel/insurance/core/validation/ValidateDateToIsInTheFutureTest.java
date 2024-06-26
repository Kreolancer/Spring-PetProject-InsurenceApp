package travel.insurance.core.validation;

import travel.insurance.core.util.DateTimeUtil;
import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
public class ValidateDateToIsInTheFutureTest {
    @InjectMocks
    private ValidateDateToIsInTheFuture validator = new ValidateDateToIsInTheFuture();
    @Mock
    private ValidationErrorFactory factoryMock;
    @Mock
    private DateTimeUtil dateTimeUtilMock;
    @Mock
    private TravelCalculatePremiumRequest requestMock;
    @Mock
    private ValidationError validationErrorMock;

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void shouldReturnErrorWhenAgreementDateToInThePast() {
        when(requestMock.getAgreementDateTo()).thenReturn(createDate("02.01.2007"));
        when(dateTimeUtilMock.getTodaysDateAndTime()).thenReturn(createDate("01.01.2024"));
        when(factoryMock.createError("ERROR_CODE_4")).thenReturn(validationErrorMock);
        Optional<ValidationError> errorOptional = validator.validate(requestMock);
        assertTrue(errorOptional.isPresent());
        assertEquals(errorOptional.get(), validationErrorMock);
    }

    @Test
    public void shouldNotReturnErrorWhenAgreementDateToInFuture() {
        when(requestMock.getAgreementDateTo()).thenReturn(createDate("02.01.2027"));
        when(dateTimeUtilMock.getTodaysDateAndTime()).thenReturn(createDate("01.01.2024"));
        Optional<ValidationError> errorOptional = validator.validate(requestMock);
        assertTrue(errorOptional.isEmpty());
        verifyNoInteractions(factoryMock, validationErrorMock);
    }
}
