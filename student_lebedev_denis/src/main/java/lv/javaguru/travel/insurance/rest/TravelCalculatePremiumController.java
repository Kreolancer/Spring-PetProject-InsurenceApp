package lv.javaguru.travel.insurance.rest;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
import lv.javaguru.travel.insurance.core.TravelCalculatePremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance/travel")
public class TravelCalculatePremiumController {

    @Autowired
    private TravelCalculatePremiumService calculatePremiumService;
    @Autowired
    private TravelCalculatePremiumRequestLogger requestLogger;
    @Autowired
    private TravelCalculatePremiumResponseLogger responseLogger;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public TravelCalculatePremiumResponse calculatePremium(@RequestBody TravelCalculatePremiumRequest request) {
        requestLogger.log(request);
        TravelCalculatePremiumResponse response =  calculatePremiumService.calculatePremium(request);
        responseLogger.log(response);
        return response;
    }

}