package lv.javaguru.travel.insurance.dto;

import lombok.*;
import lv.javaguru.travel.insurance.dto.CoreResponse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelCalculatePremiumResponse extends CoreResponse {

    private String personFirstName;
    private String personLastName;
    private Date agreementDateFrom;
    private Date agreementDateTo;

    private BigDecimal agreementPrice;

    public TravelCalculatePremiumResponse(List<ValidationError> errors) {
        super(errors);
    }
}