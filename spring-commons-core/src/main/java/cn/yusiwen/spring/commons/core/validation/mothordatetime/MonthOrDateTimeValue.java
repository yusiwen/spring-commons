package cn.yusiwen.spring.commons.core.validation.mothordatetime;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates that a string is a valid month ({@code yyyy-MM}) or date-time
 * ({@code yyyy-MM-dd HH:mm:ss}).
 */
@Documented
@Constraint(validatedBy = MonthOrDateTimeValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MonthOrDateTimeValue {

    String message() default "Invalid format, expected yyyy-MM or yyyy-MM-dd HH:mm:ss";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        MonthOrDateTimeValue[] value();
    }
}
