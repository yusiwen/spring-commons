package cn.yusiwen.spring.commons.core.enums;

public enum YesOrNotEnum {

    Y("Y", "Yes"),
    N("N", "No");

    private final String code;
    private final String message;

    YesOrNotEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
