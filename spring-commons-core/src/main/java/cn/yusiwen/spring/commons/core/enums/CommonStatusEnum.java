package cn.yusiwen.spring.commons.core.enums;

public enum CommonStatusEnum {

    ENABLE(0, "Enable"),
    DISABLE(1, "Disable"),
    DELETED(2, "Deleted");

    private final Integer code;
    private final String message;

    CommonStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static boolean isValidStatus(Integer code) {
        return code != null && (code.equals(ENABLE.code) || code.equals(DISABLE.code));
    }
}
