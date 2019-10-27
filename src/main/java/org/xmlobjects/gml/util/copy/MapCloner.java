package org.xmlobjects.gml.util.copy;

import java.util.Map;
import java.util.Set;

public class MapCloner<T extends Map> implements Cloner<T> {

    MapCloner() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public T copy(T src, T dest, Map<Object, Object> clones, boolean shallowCopy, CopyBuilder builder) throws Exception {
        if (dest == null)
            dest = (T) src.getClass().getDeclaredConstructor().newInstance();

        clones.put(src, dest);

        if (shallowCopy)
            dest.putAll(src);
        else {
            Set<Map.Entry> entries = src.entrySet();
            for (Map.Entry entry : entries) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                dest.put(deepCopy(key, builder), deepCopy(value, builder));
            }
        }

        return dest;
    }
}
