package cn.yusiwen.spring.commons.core.factory;

import cn.yusiwen.spring.commons.core.annotation.ExpEnumType;

import java.lang.reflect.Field;

public class ExpEnumCodeFactory {

    private ExpEnumCodeFactory() {
    }

    public static Integer getExpCodeByLevel(Class<?> levelClass, int code, int... more) {
        ExpEnumType type = levelClass.getAnnotation(ExpEnumType.class);
        if (type == null) {
            return 999999;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(type.module()).append(type.kind()).append(code);
        for (int i : more) {
            builder.append(i);
        }
        return Integer.parseInt(builder.toString());
    }

    public static int getFieldValue(Field field, Object obj) {
        try {
            return Integer.parseInt(String.valueOf(field.get(obj)));
        } catch (IllegalAccessException e) {
            return 0;
        }
    }
}
