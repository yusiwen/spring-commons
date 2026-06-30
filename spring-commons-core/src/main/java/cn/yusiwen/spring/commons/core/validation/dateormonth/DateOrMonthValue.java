package cn.yusiwen.spring.commons.core.validation.dateormonth;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates that a string is a valid date ({@code yyyy-MM-dd}) or month
 * ({@code yyyy-MM}).
 */
@Documented
@Constraint(validatedBy = DateOrMonthValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOrMonthValue {

    String message() default "Invalid format, expected yyyy-MM-dd or yyyy-MM";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DateOrMonthValue[] value();
    }
}
