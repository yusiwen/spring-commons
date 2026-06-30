package cn.yusiwen.spring.commons.core.validation.dateortime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validator for {@link DateOrTimeValue}.
 */
public class DateOrTimeValueValidator implements ConstraintValidator<DateOrTimeValue, String> {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        if (value.length() == 10) {
            try {
                LocalDate.parse(value, DATE_FMT);
                return true;
            } catch (DateTimeParseException ignored) {
            }
        }
        if (value.length() == 8) {
            try {
                LocalTime.parse(value, TIME_FMT);
                return true;
            } catch (DateTimeParseException ignored) {
            }
        }
        return false;
    }
}
