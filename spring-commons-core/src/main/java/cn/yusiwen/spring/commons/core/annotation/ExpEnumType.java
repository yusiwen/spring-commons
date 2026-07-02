package cn.yusiwen.spring.commons.core.annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ExpEnumType {

    int module() default 99;

    int kind() default 9999;
}
