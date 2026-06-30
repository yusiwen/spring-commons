package cn.yusiwen.spring.commons.core.validation.mothordatetime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validator for {@link MonthOrDateTimeValue}.
 */
public class MonthOrDateTimeValueValidator implements ConstraintValidator<MonthOrDateTimeValue, String> {

    private static final DateTimeFormatter MONTH_FMT = DateTimeFormatter.ofPattern("yyyy-MM");
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        if (value.length() == 7) {
            try {
                YearMonth.parse(value, MONTH_FMT);
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
