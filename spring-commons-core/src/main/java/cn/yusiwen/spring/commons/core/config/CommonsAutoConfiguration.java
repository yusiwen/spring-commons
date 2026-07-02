package cn.yusiwen.spring.commons.core.config;

import cn.yusiwen.spring.commons.core.exception.MyUncaughtExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Core configuration class for the spring-commons module.
 * <p>Scans for components in the base package, registering response wrappers,
 * exception handlers, and custom validators.</p>
 */
@Configuration
@ComponentScan("cn.yusiwen.spring.commons.core")
@ConditionalOnProperty(prefix = "commons", name = "enabled", matchIfMissing = true)
public class CommonsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MyUncaughtExceptionHandler myUncaughtExceptionHandler() {
        MyUncaughtExceptionHandler handler = new MyUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(handler);
        return handler;
    }
}
