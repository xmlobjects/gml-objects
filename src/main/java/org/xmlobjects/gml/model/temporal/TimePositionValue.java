package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.util.copy.Copyable;

public interface TimePositionValue<T> extends Copyable {
    T getValue();

    @Override
    default Copyable shallowCopy(CopyBuilder builder) {
        return this;
    }

    @Override
    default Copyable deepCopy(CopyBuilder builder) {
        return this;
    }
}
