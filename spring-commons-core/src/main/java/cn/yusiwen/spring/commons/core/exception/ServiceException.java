package cn.yusiwen.spring.commons.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Base business exception.
 * <p>Thrown when a business rule is violated. Carries a numeric error code
 * and a human-readable message.</p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {

    private Integer code;

    private String errorMessage;

    public ServiceException(Integer code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(AbstractBaseExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }
}
