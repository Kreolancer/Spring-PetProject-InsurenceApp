package lv.javaguru.travel.insurance.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class TravelCalculatePremiumRequest {
    private String personFirstName;
    private String personLastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date agreementDateFrom;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date agreementDateTo;

    private List<String> selectedRisks;

    private String country;
}
