package cn.yusiwen.spring.commons.core.validation.time;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validator for {@link TimeValue}.
 */
public class TimeValueValidator implements ConstraintValidator<TimeValue, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        if (value.length() != 8) {
            return false;
        }
        try {
            LocalTime.parse(value, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
