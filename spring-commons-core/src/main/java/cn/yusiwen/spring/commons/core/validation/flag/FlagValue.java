package cn.yusiwen.spring.commons.core.validation.flag;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates that a string value is either {@code "Y"} or {@code "N"}.
 * <p>If {@link #required()} is {@code false}, empty values are allowed.</p>
 */
@Documented
@Constraint(validatedBy = FlagValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FlagValue {

    String message() default "Invalid flag value, must be Y or N";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /** Whether the value is required. Defaults to {@code true}. */
    boolean required() default true;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        FlagValue[] value();
    }
}
