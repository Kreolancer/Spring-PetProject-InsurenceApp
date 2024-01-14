package lv.javaguru.travel.insurance.core.underwriting.calculators;

import lv.javaguru.travel.insurance.core.underwriting.TravelRiskPremiumCalculator;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.travel.insurance.core.util.DateTimeUtil.findDiffBetweenTwoDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TravelRiskPremiumCalculatorMedicalTest {
    TravelRiskPremiumCalculatorMedical calculator = new TravelRiskPremiumCalculatorMedical();
    TravelCalculatePremiumRequest request;
    @BeforeEach
    public void init() {
        request = mock(TravelCalculatePremiumRequest.class);
        List<String> risks = new ArrayList<>();
        risks.add(calculator.getIc());
        when(request.getAgreementDateTo()).thenReturn(Date.valueOf("2026-09-12"));
        when(request.getAgreementDateFrom()).thenReturn(Date.valueOf("2026-09-11"));
        when(request.getSelected_risks()).thenReturn(risks);
    }

    @Test
    public void calculatePremiumTest() {
        assertEquals(calculator.calculatePremium(request), BigDecimal.ONE);
    }
}