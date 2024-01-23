package lv.javaguru.travel.insurance.core.repositories;

import lv.javaguru.travel.insurance.core.domain.CountryDefaultDayRate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryDefaultDayRateRepository extends JpaRepository<CountryDefaultDayRate, Long> {

    @Cacheable(cacheNames = {"countryDefaultDayRateCache"}, key = "#countryIc", condition="#result != null")
    Optional<CountryDefaultDayRate> findByCountryIc(String countryIc);
}
