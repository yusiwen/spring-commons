package cn.yusiwen.spring.commons.core.response;

/**
 * Success response wrapper.
 * <p>Convenience subclass of {@link ResponseData} with {@code success = true}
 * and {@code code = 200} by default.</p>
 */
public class SuccessResponseData extends ResponseData {

    public SuccessResponseData() {
        super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null);
    }

    public SuccessResponseData(Object data) {
        super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, data);
    }

    public SuccessResponseData(Integer code, String message, Object data) {
        super(true, code, message, data);
    }

    public SuccessResponseData(String message, Object data) {
        super(true, DEFAULT_SUCCESS_CODE, message, data);
    }
}
