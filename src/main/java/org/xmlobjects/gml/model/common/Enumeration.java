package org.xmlobjects.gml.model.common;

public interface Enumeration<T extends Enumeration> {
    String toValue();
    T fromValue(String value);
}
