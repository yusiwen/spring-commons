package cn.yusiwen.spring.commons.core.validation.month;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validator for {@link MonthValue}.
 */
public class MonthValueValidator implements ConstraintValidator<MonthValue, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        if (value.length() != 7) {
            return false;
        }
        try {
            YearMonth.parse(value, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
