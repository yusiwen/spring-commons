package cn.yusiwen.spring.commons.core.response;

import lombok.Data;

/**
 * Standard API response wrapper.
 * <p>All REST controllers should return this type to provide a consistent
 * response structure: {@code success}, {@code code}, {@code message}, and
 * {@code data}.</p>
 */
@Data
public class ResponseData {

    /** Default success message. */
    public static final String DEFAULT_SUCCESS_MESSAGE = "Success";

    /** Default error message. */
    public static final String DEFAULT_ERROR_MESSAGE = "Internal Server Error";

    /** Default success HTTP status code. */
    public static final Integer DEFAULT_SUCCESS_CODE = 200;

    /** Default error HTTP status code. */
    public static final Integer DEFAULT_ERROR_CODE = 500;

    /** Whether the request was successful. */
    private Boolean success;

    /** Response status code. */
    private Integer code;

    /** Response message. */
    private String message;

    /** Response payload. */
    private Object data;

    public ResponseData() {
    }

    public ResponseData(Boolean success, Integer code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Creates a success response with no payload.
     *
     * @return a new {@link SuccessResponseData}
     */
    public static SuccessResponseData success() {
        return new SuccessResponseData();
    }

    /**
     * Creates a success response with the given payload.
     *
     * @param data the response payload
     * @return a new {@link SuccessResponseData}
     */
    public static SuccessResponseData success(Object data) {
        return new SuccessResponseData(data);
    }

    /**
     * Creates a success response with the given code, message, and payload.
     *
     * @param code    the response code
     * @param message the response message
     * @param data    the response payload
     * @return a new {@link SuccessResponseData}
     */
    public static SuccessResponseData success(Integer code, String message, Object data) {
        return new SuccessResponseData(code, message, data);
    }

    /**
     * Creates an error response with the given message.
     *
     * @param message the error message
     * @return a new {@link ErrorResponseData}
     */
    public static ErrorResponseData error(String message) {
        return new ErrorResponseData(message);
    }

    /**
     * Creates an error response with the given code and message.
     *
     * @param code    the error code
     * @param message the error message
     * @return a new {@link ErrorResponseData}
     */
    public static ErrorResponseData error(Integer code, String message) {
        return new ErrorResponseData(code, message);
    }

    /**
     * Creates an error response with the given code, message, and payload.
     *
     * @param code    the error code
     * @param message the error message
     * @param data    the response payload
     * @return a new {@link ErrorResponseData}
     */
    public static ErrorResponseData error(Integer code, String message, Object data) {
        return new ErrorResponseData(code, message, data);
    }
}
