package cn.yusiwen.spring.commons.core.validation.date;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates that a string is a valid date in the format {@code yyyy-MM-dd}.
 */
@Documented
@Constraint(validatedBy = DateValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateValue {

    String message() default "Invalid date format, expected yyyy-MM-dd";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DateValue[] value();
    }
}
