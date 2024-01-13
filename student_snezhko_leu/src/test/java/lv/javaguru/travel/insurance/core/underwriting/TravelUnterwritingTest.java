package lv.javaguru.travel.insurance.core.underwriting;

//import lv.javaguru.travel.insurance.core.underwriting.TravelUnderwritingImpl;
import lv.javaguru.travel.insurance.core.underwriting.calculators.TravelRiskPremiumCalculatorMedical;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
        import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
        import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TravelUnterwritingTest {

    @InjectMocks
    TravelUnderwriting underwriting = new TravelUnderwritingImpl();
    //TravelRiskPremiumCalculator med = mock(TravelRiskPremiumCalculatorMedical.class);
    @Test
    public void calculatePremiumTest() {
        List<String> risks = new ArrayList<>();
        risks.add("TRAVEL_MEDICAL");
        //TravelCalculatePremiumResponse response = mock(TravelCalculatePremiumResponse.class);
        TravelCalculatePremiumRequest request = mock(TravelCalculatePremiumRequest.class);

        when(request.getAgreementDateTo()).thenReturn(Date.valueOf("2022-09-12"));
       when(request.getAgreementDateFrom()).thenReturn(Date.valueOf("2022-09-11"));
       when(request.getSelected_risks()).thenReturn(risks);

        List<TravelRiskPremiumCalculator> calculatorList = new ArrayList<>();
        calculatorList.add(new TravelRiskPremiumCalculatorMedical());
        ReflectionTestUtils.setField(underwriting, "riskCalculators", calculatorList);
       //when(response.getSelected_risks()).thenReturn(risks);
        assertEquals(BigDecimal.valueOf(1),underwriting.calculatePremium(request));
    }
/*
    @Test
    public void ToLargeThenFromAgreementTest() {
        TravelCalculatePremiumResponse response = mock(TravelCalculatePremiumResponse.class);

        when(response.getAgreementDateFrom()).thenReturn(Date.valueOf("11.09.2022"));
        when(response.getAgreementDateFrom()).thenReturn(Date.valueOf("13.09.2022"));

        assertEquals(TravelUnderwriting.getAgreementPrice(Date.valueOf("2022-09-12"), Date.valueOf("2022-09-11")), BigDecimal.valueOf(86400000));
    }
    */
}