package lv.javaguru.travel.insurance.dto;

import lv.javaguru.travel.insurance.core.underwriting.TravelRiskPremiumCalculator;
import lv.javaguru.travel.insurance.core.underwriting.SelectedRisksPremiumCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TravelCalculatePremiumRiskFactory {
    @Autowired
    private SelectedRisksPremiumCalculator calculator;
    /*
    public TravelCalculatePremiumRisk buildRisk(TravelRiskPremiumCalculator calculator, TravelCalculatePremiumRequest request) {
        return request.getSelected_risks().contains(calculator.getIc()) ? new TravelCalculatePremiumRisk(calculator.getIc(), calculator.calculatePremium(request)) : null; //return calculator.findCalculatorByIc(ic);
    }
*/
    public List<TravelCalculatePremiumRisk> buildRisksList(TravelCalculatePremiumRequest request) {//List<TravelRiskPremiumCalculator> calculators, TravelCalculatePremiumRequest request) {
        //List<TravelCalculatePremiumRisk> result = new ArrayList<>();

        /*
        for (TravelRiskPremiumCalculator calculator : calculators) {
            TravelCalculatePremiumRisk risk = buildRisk(calculator, request);
            if (risk != null) {
                result.add(risk);
            }
        }
         */
        return calculator.calculatePremiumForAllRisks(request);//result;
    }
}
