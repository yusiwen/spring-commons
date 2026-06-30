package cn.yusiwen.spring.commons.core.validation.time;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates that a string is a valid time in the format {@code HH:mm:ss}.
 */
@Documented
@Constraint(validatedBy = TimeValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeValue {

    String message() default "Invalid time format, expected HH:mm:ss";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        TimeValue[] value();
    }
}
