package cn.yusiwen.spring.commons.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(MyUncaughtExceptionHandler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.error("Uncaught exception in thread [{}]: {}", t.getName(), e.getMessage(), e);
    }
}
