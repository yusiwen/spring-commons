package cn.yusiwen.spring.commons.core.handler;

import cn.yusiwen.spring.commons.core.exception.AuthException;
import cn.yusiwen.spring.commons.core.exception.PermissionException;
import cn.yusiwen.spring.commons.core.exception.ServiceException;
import cn.yusiwen.spring.commons.core.response.ErrorResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler that converts exceptions into standardized
 * {@link ErrorResponseData} responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles {@link ServiceException} and returns HTTP 500.
     *
     * @param e the service exception
     * @return a response entity with {@link ErrorResponseData}
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponseData> handleServiceException(ServiceException e) {
        log.warn("Service exception: code={}, message={}", e.getCode(), e.getErrorMessage());
        ErrorResponseData error = new ErrorResponseData(e.getCode(), e.getErrorMessage());
        error.setExceptionClazz(e.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    /**
     * Handles {@link AuthException} and returns HTTP 401.
     *
     * @param e the auth exception
     * @return a response entity with {@link ErrorResponseData}
     */
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorResponseData> handleAuthException(AuthException e) {
        log.warn("Auth exception: code={}, message={}", e.getCode(), e.getErrorMessage());
        ErrorResponseData error = new ErrorResponseData(e.getCode(), e.getErrorMessage());
        error.setExceptionClazz(e.getClass().getName());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    /**
     * Handles {@link PermissionException} and returns HTTP 403.
     *
     * @param e the permission exception
     * @return a response entity with {@link ErrorResponseData}
     */
    @ExceptionHandler(PermissionException.class)
    public ResponseEntity<ErrorResponseData> handlePermissionException(PermissionException e) {
        log.warn("Permission exception: code={}, message={}", e.getCode(), e.getErrorMessage());
        ErrorResponseData error = new ErrorResponseData(e.getCode(), e.getErrorMessage());
        error.setExceptionClazz(e.getClass().getName());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    /**
     * Handles unhandled exceptions and returns HTTP 500.
     *
     * @param e the unexpected exception
     * @return a response entity with {@link ErrorResponseData}
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseData> handleException(Exception e) {
        log.error("Unexpected exception", e);
        ErrorResponseData error = new ErrorResponseData(
                ErrorResponseData.DEFAULT_ERROR_CODE,
                ErrorResponseData.DEFAULT_ERROR_MESSAGE);
        error.setExceptionClazz(e.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
