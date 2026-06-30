package cn.yusiwen.spring.commons.test;

import cn.yusiwen.spring.commons.core.validation.date.DateValue;
import cn.yusiwen.spring.commons.core.validation.datetime.DateTimeValue;
import cn.yusiwen.spring.commons.core.validation.time.TimeValue;
import cn.yusiwen.spring.commons.core.validation.month.MonthValue;
import cn.yusiwen.spring.commons.core.validation.flag.FlagValue;
import cn.yusiwen.spring.commons.core.validation.dateortime.DateOrTimeValue;
import cn.yusiwen.spring.commons.core.validation.dateordatetime.DateOrDateTimeValue;
import cn.yusiwen.spring.commons.core.validation.dateormonth.DateOrMonthValue;
import cn.yusiwen.spring.commons.core.validation.mothordatetime.MonthOrDateTimeValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ValidationTest {

    @Autowired
    private Validator validator;

    @Test
    void dateValue_valid() {
        DateValueBean bean = new DateValueBean("2026-06-30");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void dateValue_invalid() {
        DateValueBean bean = new DateValueBean("2026-13-01");
        assertThat(validator.validate(bean)).isNotEmpty();
    }

    @Test
    void dateValue_invalidFormat() {
        DateValueBean bean = new DateValueBean("2026/06/30");
        assertThat(validator.validate(bean)).isNotEmpty();
    }

    @Test
    void dateTimeValue_valid() {
        DateTimeValueBean bean = new DateTimeValueBean("2026-06-30 15:30:00");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void dateTimeValue_invalid() {
        DateTimeValueBean bean = new DateTimeValueBean("2026-06-30 25:00:00");
        assertThat(validator.validate(bean)).isNotEmpty();
    }

    @Test
    void timeValue_valid() {
        TimeValueBean bean = new TimeValueBean("15:30:00");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void timeValue_invalid() {
        TimeValueBean bean = new TimeValueBean("25:00:00");
        assertThat(validator.validate(bean)).isNotEmpty();
    }

    @Test
    void monthValue_valid() {
        MonthValueBean bean = new MonthValueBean("2026-06");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void monthValue_invalid() {
        MonthValueBean bean = new MonthValueBean("2026-13");
        assertThat(validator.validate(bean)).isNotEmpty();
    }

    @Test
    void flagValue_valid() {
        FlagValueBean bean = new FlagValueBean("Y");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void flagValue_invalid() {
        FlagValueBean bean = new FlagValueBean("X");
        assertThat(validator.validate(bean)).isNotEmpty();
    }

    @Test
    void flagValue_optionalNull() {
        FlagValueOptionalBean bean = new FlagValueOptionalBean(null);
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void dateOrTimeValue_date() {
        DateOrTimeValueBean bean = new DateOrTimeValueBean("2026-06-30");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void dateOrTimeValue_time() {
        DateOrTimeValueBean bean = new DateOrTimeValueBean("15:30:00");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void dateOrTimeValue_invalid() {
        DateOrTimeValueBean bean = new DateOrTimeValueBean("invalid");
        assertThat(validator.validate(bean)).isNotEmpty();
    }

    @Test
    void dateOrDateTimeValue_date() {
        DateOrDateTimeValueBean bean = new DateOrDateTimeValueBean("2026-06-30");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void dateOrDateTimeValue_datetime() {
        DateOrDateTimeValueBean bean = new DateOrDateTimeValueBean("2026-06-30 15:30:00");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void dateOrMonthValue_date() {
        DateOrMonthValueBean bean = new DateOrMonthValueBean("2026-06-30");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void dateOrMonthValue_month() {
        DateOrMonthValueBean bean = new DateOrMonthValueBean("2026-06");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void monthOrDateTimeValue_month() {
        MonthOrDateTimeValueBean bean = new MonthOrDateTimeValueBean("2026-06");
        assertThat(validator.validate(bean)).isEmpty();
    }

    @Test
    void monthOrDateTimeValue_datetime() {
        MonthOrDateTimeValueBean bean = new MonthOrDateTimeValueBean("2026-06-30 15:30:00");
        assertThat(validator.validate(bean)).isEmpty();
    }

    // --- Bean classes for validation testing ---

    static class DateValueBean {
        @DateValue
        private final String value;
        DateValueBean(String value) { this.value = value; }
        public String getValue() { return value; }
    }

    static class DateTimeValueBean {
        @DateTimeValue
        private final String value;
        DateTimeValueBean(String value) { this.value = value; }
        public String getValue() { return value; }
    }

    static class TimeValueBean {
        @TimeValue
        private final String value;
        TimeValueBean(String value) { this.value = value; }
        public String getValue() { return value; }
    }

    static class MonthValueBean {
        @MonthValue
        private final String value;
        MonthValueBean(String value) { this.value = value; }
        public String getValue() { return value; }
    }

    static class FlagValueBean {
        @FlagValue
        private final String value;
        FlagValueBean(String value) { this.value = value; }
        public String getValue() { return value; }
    }

    static class FlagValueOptionalBean {
        @FlagValue(required = false)
        private final String value;
        FlagValueOptionalBean(String value) { this.value = value; }
        public String getValue() { return value; }
    }

    static class DateOrTimeValueBean {
        @DateOrTimeValue
        private final String value;
        DateOrTimeValueBean(String value) { this.value = value; }
        public String getValue() { return value; }
    }

    static class DateOrDateTimeValueBean {
        @DateOrDateTimeValue
        private final String value;
        DateOrDateTimeValueBean(String value) { this.value = value; }
        public String getValue() { return value; }
    }

    static class DateOrMonthValueBean {
        @DateOrMonthValue
        private final String value;
        DateOrMonthValueBean(String value) { this.value = value; }
        public String getValue() { return value; }
    }

    static class MonthOrDateTimeValueBean {
        @MonthOrDateTimeValue
        private final String value;
        MonthOrDateTimeValueBean(String value) { this.value = value; }
        public String getValue() { return value; }
    }
}
