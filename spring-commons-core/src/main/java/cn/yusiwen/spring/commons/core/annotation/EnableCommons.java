package cn.yusiwen.spring.commons.core.annotation;

import cn.yusiwen.spring.commons.core.config.CommonsAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Enables the spring-commons module.
 * <p>Add this annotation to a {@code @Configuration} class to manually enable
 * the common web infrastructure, including response wrappers, exception framework,
 * custom validators, and global exception handling. When using
 * {@code spring-commons-starter}, this annotation is optional as auto-configuration
 * is enabled by default.</p>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CommonsAutoConfiguration.class)
public @interface EnableCommons {
}
