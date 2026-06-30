package cn.yusiwen.spring.commons.core.validation.month;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates that a string is a valid month in the format {@code yyyy-MM}.
 */
@Documented
@Constraint(validatedBy = MonthValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MonthValue {

    String message() default "Invalid month format, expected yyyy-MM";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        MonthValue[] value();
    }
}
