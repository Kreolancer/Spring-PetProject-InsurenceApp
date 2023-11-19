package lv.javaguru.travel.insurance.core;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class DateFunctions {
    public static long daysBetween (Date firstDate, Date secondDate) {
        return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
    }

    public static Date createDateFromString (String stringDate) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            return dateFormat.parse(stringDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
