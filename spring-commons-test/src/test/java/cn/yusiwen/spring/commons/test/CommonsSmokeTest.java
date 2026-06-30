package cn.yusiwen.spring.commons.test;

import cn.yusiwen.spring.commons.core.handler.GlobalExceptionHandler;
import cn.yusiwen.spring.commons.core.response.ResponseData;
import cn.yusiwen.spring.commons.core.response.SuccessResponseData;
import cn.yusiwen.spring.commons.core.response.ErrorResponseData;
import cn.yusiwen.spring.commons.core.response.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CommonsSmokeTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertThat(context).isNotNull();
    }

    @Test
    void globalExceptionHandlerIsRegistered() {
        assertThat(context.getBean(GlobalExceptionHandler.class)).isNotNull();
    }

    @Test
    void responseDataSuccess() {
        ResponseData result = ResponseData.success();
        assertThat(result.getSuccess()).isTrue();
        assertThat(result.getCode()).isEqualTo(200);
        assertThat(result.getMessage()).isEqualTo("Success");
    }

    @Test
    void responseDataSuccessWithData() {
        ResponseData result = ResponseData.success("hello");
        assertThat(result.getSuccess()).isTrue();
        assertThat(result.getData()).isEqualTo("hello");
    }

    @Test
    void responseDataError() {
        ResponseData result = ResponseData.error("something went wrong");
        assertThat(result.getSuccess()).isFalse();
        assertThat(result.getCode()).isEqualTo(500);
        assertThat(result.getMessage()).isEqualTo("something went wrong");
    }

    @Test
    void successResponseDataDefaults() {
        SuccessResponseData srd = new SuccessResponseData();
        assertThat(srd.getSuccess()).isTrue();
        assertThat(srd.getCode()).isEqualTo(200);
        assertThat(srd.getMessage()).isEqualTo("Success");
    }

    @Test
    void errorResponseDataDefaults() {
        ErrorResponseData erd = new ErrorResponseData("error");
        assertThat(erd.getSuccess()).isFalse();
        assertThat(erd.getCode()).isEqualTo(500);
        assertThat(erd.getMessage()).isEqualTo("error");
    }

    @Test
    void pageResult() {
        List<String> rows = Arrays.asList("a", "b");
        PageResult<String> pr = new PageResult<>(1, 10, 1, 2, rows);
        assertThat(pr.getPageNo()).isEqualTo(1);
        assertThat(pr.getPageSize()).isEqualTo(10);
        assertThat(pr.getTotalRows()).isEqualTo(2);
        assertThat(pr.getRows()).hasSize(2);
    }
}
