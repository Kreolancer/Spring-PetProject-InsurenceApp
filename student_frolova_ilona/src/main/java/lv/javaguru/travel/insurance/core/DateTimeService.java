package lv.javaguru.travel.insurance.core;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;

@Component
public class DateTimeService {

    public BigDecimal getDifferenceInDays(Date date1, Date date2) {
        BigDecimal difference = new BigDecimal(date2.getTime() - date1.getTime());
        difference = difference.divide(BigDecimal.valueOf(1000.0), MathContext.DECIMAL128);
        difference = difference.divide(BigDecimal.valueOf(86400.0), MathContext.DECIMAL128);

        return difference;
    }
}
