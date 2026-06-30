package cn.yusiwen.spring.commons.starter;

import cn.yusiwen.spring.commons.core.config.CommonsAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring Boot auto-configuration entry point for spring-commons.
 * <p>Registered via {@code META-INF/spring.factories} and automatically
 * imported when this starter is on the classpath.</p>
 */
@Configuration
@Import(CommonsAutoConfiguration.class)
public class StarterAutoConfiguration {
}

