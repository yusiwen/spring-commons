package cn.yusiwen.spring.commons.core.validation.date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validator for {@link DateValue}.
 */
public class DateValueValidator implements ConstraintValidator<DateValue, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        if (value.length() != 10) {
            return false;
        }
        try {
            LocalDate.parse(value, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
