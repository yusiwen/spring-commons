package cn.yusiwen.spring.commons.core.exception;

import lombok.Getter;

/**
 * Authorization exception.
 * <p>Thrown when a user lacks the required permissions to access a resource
 * or perform an operation. Results in an HTTP 403 response.</p>
 */
@Getter
public class PermissionException extends RuntimeException {

    private final Integer code;

    private final String errorMessage;

    public PermissionException(AbstractBaseExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }
}
