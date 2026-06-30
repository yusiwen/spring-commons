package cn.yusiwen.spring.commons.core.exception;

import lombok.Getter;

/**
 * Authentication exception.
 * <p>Thrown when a user fails authentication (e.g., invalid token, expired
 * login, wrong credentials). Results in an HTTP 401 response.</p>
 */
@Getter
public class AuthException extends RuntimeException {

    private final Integer code;

    private final String errorMessage;

    public AuthException(AbstractBaseExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }

    public AuthException(int code, String message) {
        super(message);
        this.code = code;
        this.errorMessage = message;
    }
}
