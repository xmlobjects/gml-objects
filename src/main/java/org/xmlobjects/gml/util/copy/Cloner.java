package org.xmlobjects.gml.util.copy;

import java.util.Map;

public interface Cloner<T> {
    T copy(T src, T dest, Map<Object, Object> clones, boolean shallowCopy, CopyBuilder builder) throws Exception;

    @SuppressWarnings("unchecked")
    default <E> E deepCopy(E value, CopyBuilder builder) {
        return value instanceof Copyable ?
                (E) ((Copyable) value).deepCopy(builder) :
                builder.deepCopy(value);
    }
}
