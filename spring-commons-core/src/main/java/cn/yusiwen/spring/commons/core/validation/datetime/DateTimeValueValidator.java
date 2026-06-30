package cn.yusiwen.spring.commons.core.validation.datetime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validator for {@link DateTimeValue}.
 */
public class DateTimeValueValidator implements ConstraintValidator<DateTimeValue, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        if (value.length() != 19) {
            return false;
        }
        try {
            LocalDateTime.parse(value, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
