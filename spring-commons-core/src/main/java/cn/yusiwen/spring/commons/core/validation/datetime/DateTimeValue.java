package cn.yusiwen.spring.commons.core.validation.datetime;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates that a string is a valid date-time in the format
 * {@code yyyy-MM-dd HH:mm:ss}.
 */
@Documented
@Constraint(validatedBy = DateTimeValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateTimeValue {

    String message() default "Invalid datetime format, expected yyyy-MM-dd HH:mm:ss";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DateTimeValue[] value();
    }
}
