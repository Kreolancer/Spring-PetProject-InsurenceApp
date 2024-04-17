package travel.insurance.rest;

import com.google.common.base.Stopwatch;
import travel.insurance.core.service.TravelCalculatePremiumService;
import travel.insurance.dto.TravelCalculatePremiumRequest;
import travel.insurance.dto.TravelCalculatePremiumResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance/travel")
public class TravelCalculatePremiumController {
	@Autowired
	private TravelCalculatePremiumService calculatePremiumService;
	@Autowired
	private TravelCalculatePremiumRequestLogger reqLogger;
	@Autowired
	private TravelCalculatePremiumResponseLogger respLogger;
	@Autowired
	private TravelCalculatePremiumRequestExecutionTimeLogger execTimeLogger;

	@PostMapping(path = "/",
			consumes = "application/json",
			produces = "application/json")
	public TravelCalculatePremiumResponse calculatePremium(@RequestBody TravelCalculatePremiumRequest request) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		TravelCalculatePremiumResponse response = makeEverything(request);
		execTimeLogger.logExecutionTime(stopwatch);
		return response;
	}

	public TravelCalculatePremiumResponse makeEverything(TravelCalculatePremiumRequest request) {
		reqLogger.log(request);
		TravelCalculatePremiumResponse response = calculatePremiumService.calculatePremium(request);
		respLogger.log(response);
		return response;
	}
}