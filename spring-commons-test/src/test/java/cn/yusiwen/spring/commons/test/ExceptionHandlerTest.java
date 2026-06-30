package cn.yusiwen.spring.commons.test;

import cn.yusiwen.spring.commons.core.exception.AuthException;
import cn.yusiwen.spring.commons.core.exception.PermissionException;
import cn.yusiwen.spring.commons.core.exception.ServiceException;
import cn.yusiwen.spring.commons.core.response.ErrorResponseData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExceptionHandlerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void serviceExceptionFields() {
        ServiceException ex = new ServiceException(1001, "business error");
        assertThat(ex.getCode()).isEqualTo(1001);
        assertThat(ex.getErrorMessage()).isEqualTo("business error");
        assertThat(ex).hasMessage("business error");
    }

    @Test
    void authExceptionFields() {
        AuthException ex = new AuthException(4010, "token expired");
        assertThat(ex.getCode()).isEqualTo(4010);
        assertThat(ex.getErrorMessage()).isEqualTo("token expired");
        assertThat(ex).hasMessage("token expired");
    }

    @Test
    void permissionExceptionFields() {
        PermissionException ex = new PermissionException(
                new AbstractBaseExceptionEnum() {
                    @Override
                    public Integer getCode() {
                        return 4030;
                    }

                    @Override
                    public String getMessage() {
                        return "access denied";
                    }
                });
        assertThat(ex.getCode()).isEqualTo(4030);
        assertThat(ex.getErrorMessage()).isEqualTo("access denied");
    }

    @Test
    void serviceExceptionFromEnum() {
        ServiceException ex = new ServiceException(new AbstractBaseExceptionEnum() {
            @Override
            public Integer getCode() {
                return 9999;
            }

            @Override
            public String getMessage() {
                return "custom error";
            }
        });
        assertThat(ex.getCode()).isEqualTo(9999);
        assertThat(ex.getErrorMessage()).isEqualTo("custom error");
    }

    private interface AbstractBaseExceptionEnum extends cn.yusiwen.spring.commons.core.exception.AbstractBaseExceptionEnum {
    }
}
