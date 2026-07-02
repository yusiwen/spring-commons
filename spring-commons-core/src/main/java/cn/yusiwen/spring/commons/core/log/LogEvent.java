package cn.yusiwen.spring.commons.core.log;

import cn.yusiwen.spring.commons.core.enums.LogAnnotionOpTypeEnum;

import java.time.LocalDateTime;

public class LogEvent {

    private final String title;
    private final LogAnnotionOpTypeEnum opType;
    private final String className;
    private final String methodName;
    private final String params;
    private final String result;
    private final LocalDateTime eventTime;
    private final long durationMs;
    private final boolean success;
    private final String errorMessage;

    public LogEvent(String title, LogAnnotionOpTypeEnum opType, String className, String methodName,
                    String params, String result, LocalDateTime eventTime, long durationMs,
                    boolean success, String errorMessage) {
        this.title = title;
        this.opType = opType;
        this.className = className;
        this.methodName = methodName;
        this.params = params;
        this.result = result;
        this.eventTime = eventTime;
        this.durationMs = durationMs;
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public String getTitle() {
        return title;
    }

    public LogAnnotionOpTypeEnum getOpType() {
        return opType;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getParams() {
        return params;
    }

    public String getResult() {
        return result;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public long getDurationMs() {
        return durationMs;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
