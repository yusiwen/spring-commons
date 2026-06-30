package cn.yusiwen.spring.commons.core.validation.dateortime;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates that a string is a valid date ({@code yyyy-MM-dd}) or time
 * ({@code HH:mm:ss}).
 */
@Documented
@Constraint(validatedBy = DateOrTimeValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOrTimeValue {

    String message() default "Invalid format, expected yyyy-MM-dd or HH:mm:ss";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DateOrTimeValue[] value();
    }
}
