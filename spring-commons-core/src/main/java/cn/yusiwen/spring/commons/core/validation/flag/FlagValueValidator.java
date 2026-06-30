package cn.yusiwen.spring.commons.core.validation.flag;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator for {@link FlagValue}.
 */
public class FlagValueValidator implements ConstraintValidator<FlagValue, String> {

    private boolean required;

    @Override
    public void initialize(FlagValue constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return "Y".equals(value) || "N".equals(value);
        }
        if (value == null || value.isEmpty()) {
            return true;
        }
        return "Y".equals(value) || "N".equals(value);
    }
}
