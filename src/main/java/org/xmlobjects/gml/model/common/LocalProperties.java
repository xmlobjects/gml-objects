package org.xmlobjects.gml.model.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class LocalProperties implements Serializable {
    private Map<String, Object> properties;

    public Object get(String name) {
        return properties != null ? properties.get(name) : null;
    }

    public <T> T get(String name, Class<T> type) {
        if (properties != null) {
            Object value = properties.get(name);
            return value != null && type.isAssignableFrom(value.getClass()) ? type.cast(value) : null;
        } else
            return null;
    }

    public boolean getAndCompare(String name, Object expectedValue) {
        return Objects.equals(get(name), expectedValue);
    }

    public <T> T getOrSet(String name, Class<T> type, Supplier<T> supplier) {
        T value = get(name, type);
        if (value == null) {
            value = supplier.get();
            set(name, value);
        }

        return value;
    }

    public boolean contains(String name) {
        return properties != null && properties.containsKey(name);
    }

    public void set(String name, Object value) {
        if (properties == null)
            properties = new HashMap<>();

        properties.put(name, value);
    }

    public boolean isEmpty() {
        return properties == null || properties.isEmpty();
    }

    public void remove(String name) {
        if (properties != null)
            properties.remove(name);
    }

    public void clear() {
        if (properties != null)
            properties.clear();
    }
}
