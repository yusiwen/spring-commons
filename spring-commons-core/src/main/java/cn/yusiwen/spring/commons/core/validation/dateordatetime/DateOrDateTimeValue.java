package cn.yusiwen.spring.commons.core.validation.dateordatetime;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates that a string is a valid date ({@code yyyy-MM-dd}) or date-time
 * ({@code yyyy-MM-dd HH:mm:ss}).
 */
@Documented
@Constraint(validatedBy = DateOrDateTimeValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOrDateTimeValue {

    String message() default "Invalid format, expected yyyy-MM-dd or yyyy-MM-dd HH:mm:ss";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DateOrDateTimeValue[] value();
    }
}
