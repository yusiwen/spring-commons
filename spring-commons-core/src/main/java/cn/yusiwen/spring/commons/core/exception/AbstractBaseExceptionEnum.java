package cn.yusiwen.spring.commons.core.exception;

/**
 * Contract for exception enums.
 * <p>Implement this interface on enums to provide a standardized error code
 * and message pair that can be used with {@link ServiceException}.</p>
 */
public interface AbstractBaseExceptionEnum {

    /**
     * Returns the error code.
     *
     * @return the error code
     */
    Integer getCode();

    /**
     * Returns the error message.
     *
     * @return the error message
     */
    String getMessage();
}
