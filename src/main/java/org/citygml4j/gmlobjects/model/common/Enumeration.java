package org.citygml4j.gmlobjects.model.common;

public interface Enumeration<T extends Enumeration> {
    String toValue();
    T fromValue(String value);
}
