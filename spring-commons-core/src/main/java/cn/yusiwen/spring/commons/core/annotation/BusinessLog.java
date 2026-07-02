package cn.yusiwen.spring.commons.core.annotation;

import cn.yusiwen.spring.commons.core.enums.LogAnnotionOpTypeEnum;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BusinessLog {

    String title() default "";

    LogAnnotionOpTypeEnum opType() default LogAnnotionOpTypeEnum.OTHER;
}
