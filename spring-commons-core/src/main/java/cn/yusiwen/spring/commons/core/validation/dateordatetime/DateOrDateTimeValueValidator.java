package cn.yusiwen.spring.commons.core.validation.dateordatetime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validator for {@link DateOrDateTimeValue}.
 */
public class DateOrDateTimeValueValidator implements ConstraintValidator<DateOrDateTimeValue, String> {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
        if (value.length() == 19) {
            try {
                LocalDateTime.parse(value, DATETIME_FMT);
                return true;
            } catch (DateTimeParseException ignored) {
            }
        }
        return false;
    }
}
