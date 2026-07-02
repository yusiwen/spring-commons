package cn.yusiwen.spring.commons.core.util;

@FunctionalInterface
public interface BeanCopyUtilCallBack<S, T> {

    void callBack(S source, T target);
}
