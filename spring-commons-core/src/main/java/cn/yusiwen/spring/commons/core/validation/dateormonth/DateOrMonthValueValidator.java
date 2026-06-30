package cn.yusiwen.spring.commons.core.validation.dateormonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validator for {@link DateOrMonthValue}.
 */
public class DateOrMonthValueValidator implements ConstraintValidator<DateOrMonthValue, String> {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter MONTH_FMT = DateTimeFormatter.ofPattern("yyyy-MM");

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
        if (value.length() == 7) {
            try {
                YearMonth.parse(value, MONTH_FMT);
                return true;
            } catch (DateTimeParseException ignored) {
            }
        }
        return false;
    }
}
