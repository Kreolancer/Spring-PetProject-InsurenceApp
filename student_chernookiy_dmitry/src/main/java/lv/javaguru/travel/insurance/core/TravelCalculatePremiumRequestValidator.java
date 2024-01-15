package lv.javaguru.travel.insurance.core;

import lv.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import lv.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TravelCalculatePremiumRequestValidator {

    Pattern firstAndLastNamePattern = Pattern.compile("^[A-Za-zА-Яа-я]+$");

    public List<ValidationError> validate(TravelCalculatePremiumRequest request) {
        List<ValidationError> errors = new ArrayList<>();

        validatePersonFirstName(request).ifPresent(errors::add);
        validatePersonLastName(request).ifPresent(errors::add);
        validatePersonDateFrom(request).ifPresent(errors::add);
        validatePersonDateTo(request).ifPresent(errors::add);
        validateDateToWithDateFrom(request).ifPresent(errors::add);
        validationDateFromInThePast(request).ifPresent(errors::add);
        validationDateToInThePast(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<ValidationError> validatePersonFirstName(TravelCalculatePremiumRequest request) {
        String firstName = request.getPersonFirstName();

        if (firstName == null || firstName.isEmpty()) {
              return Optional.of(new ValidationError("personFirstName", "Must not be empty!"));
        }

        Matcher matcher = firstAndLastNamePattern.matcher(firstName);

        if (matcher.find()) {
            return Optional.empty();
        } else {
            return Optional.of(new ValidationError("personFirstName", "Invalid"));
        }

    }

    private Optional<ValidationError> validatePersonLastName(TravelCalculatePremiumRequest request) {
        String lastName = request.getPersonLastName();

        if (lastName == null || lastName.isEmpty()) {
            return Optional.of(new ValidationError("personLastName", "Must not be empty!"));
        }

        Matcher matcher = firstAndLastNamePattern.matcher(lastName);

        if (matcher.find()) {
            return Optional.empty();
        } else {
            return Optional.of(new ValidationError("personLastName", "Invalid"));
        }
    }

    private Optional<ValidationError> validatePersonDateFrom(TravelCalculatePremiumRequest request) {
        Date dateFrom = request.getAgreementDateFrom();

        return (dateFrom == null)
                ? Optional.of(new ValidationError("agreementDateFrom", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<ValidationError> validatePersonDateTo(TravelCalculatePremiumRequest request) {
        Date dateTo = request.getAgreementDateTo();

        return (dateTo == null)
                ? Optional.of(new ValidationError("agreementDateTo", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<ValidationError> validateDateToWithDateFrom(TravelCalculatePremiumRequest request) {
        Date dateTo = request.getAgreementDateTo();
        Date dateFrom = request.getAgreementDateFrom();

        if (dateFrom != null && dateTo != null) {
            if (dateFrom.before(dateTo)) {
                return Optional.empty();
            } else {
                return Optional.of(
                        new ValidationError("Date to or date from", "Date to must be after date from"));
            }
        }
        return Optional.empty();
    }

    private Optional<ValidationError> validationDateToInThePast(TravelCalculatePremiumRequest request) {
        Date dateTo = request.getAgreementDateTo();
        Date nowDate = new Date();

        if (dateTo != null && dateTo.getTime() <= nowDate.getTime()) {
            return Optional.of(new ValidationError("dateTo", "The dateTo in the past is invalid"));
        }

        return Optional.empty();
    }

    private Optional<ValidationError> validationDateFromInThePast(TravelCalculatePremiumRequest request) {
        Date dateFrom = request.getAgreementDateTo();
        Date nowDate = new Date();

        if (dateFrom != null && dateFrom.getTime() <= nowDate.getTime()) {
            return Optional.of(new ValidationError("dateFrom", "The dateFrom in the past is invalid"));
        }

        return Optional.empty();
    }
}
