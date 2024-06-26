package travel.insurance.core.underwriting.calculators.medical;

import travel.insurance.core.domain.CountryDefaultDayRate;
import travel.insurance.core.repositories.CountryDefaultDayRateRepository;
import travel.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class Calculate_MEDICAL_FindCountryDefaultDayRate {
    @Autowired
    private CountryDefaultDayRateRepository countryDefaultDayRateRepository;
    BigDecimal findCountryDefaultDayRate(TravelCalculatePremiumRequest request) {
        return countryDefaultDayRateRepository.findByCountryIc(request.getCountry())
                .map(CountryDefaultDayRate::getDefaultDayRate)
                .orElseThrow(() -> new RuntimeException("Country day rate not found by country id = " + request.getCountry()));
    }
}
