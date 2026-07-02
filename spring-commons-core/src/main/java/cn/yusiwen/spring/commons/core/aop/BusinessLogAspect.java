package cn.yusiwen.spring.commons.core.aop;

import cn.yusiwen.spring.commons.core.annotation.BusinessLog;
import cn.yusiwen.spring.commons.core.log.LogEvent;
import cn.yusiwen.spring.commons.core.log.LogStore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
@Order(100)
public class BusinessLogAspect {

    private static final Logger log = LoggerFactory.getLogger(BusinessLogAspect.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired(required = false)
    private LogStore logStore;

    @Around("@annotation(businessLog)")
    public Object around(ProceedingJoinPoint point, BusinessLog businessLog) throws Throwable {
        long start = System.currentTimeMillis();
        String title = businessLog.title();
        String opType = businessLog.opType().name();
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();

        String params = toJson(point.getArgs());
        boolean success = true;
        String result = null;
        String errorMessage = null;

        try {
            Object returnValue = point.proceed();
            result = toJson(returnValue);
            return returnValue;
        } catch (Throwable t) {
            success = false;
            errorMessage = t.getMessage();
            throw t;
        } finally {
            long durationMs = System.currentTimeMillis() - start;
            LogEvent event = new LogEvent(title, businessLog.opType(), className, methodName,
                    params, result, LocalDateTime.now(), durationMs, success, errorMessage);
            if (logStore != null) {
                try {
                    logStore.store(event);
                } catch (Exception e) {
                    log.warn("Failed to store business log: {}", e.getMessage());
                }
            }
            log.debug("BusinessLog [{}-{}] executed in {}ms, success={}", title, opType, durationMs, success);
        }
    }

    private String toJson(Object obj) {
        if (obj == null) return null;
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            return obj.toString();
        }
    }
}
