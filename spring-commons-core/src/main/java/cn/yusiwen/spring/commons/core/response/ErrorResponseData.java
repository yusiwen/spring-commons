package cn.yusiwen.spring.commons.core.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Error response wrapper.
 * <p>Convenience subclass of {@link ResponseData} with {@code success = false}
 * and {@code code = 500} by default. Includes the exception class name for
 * debugging purposes.</p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorResponseData extends ResponseData {

    /** The fully qualified class name of the thrown exception. */
    private String exceptionClazz;

    public ErrorResponseData(String message) {
        super(false, DEFAULT_ERROR_CODE, message, null);
    }

    public ErrorResponseData(Integer code, String message) {
        super(false, code, message, null);
    }

    ErrorResponseData(Integer code, String message, Object data) {
        super(false, code, message, data);
    }
}
