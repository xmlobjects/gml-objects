package org.xmlobjects.gml.util.copy;

public interface Copyable {
    default Copyable shallowCopy(CopyBuilder builder) {
        return builder.shallowCopy(this);
    }

    default Copyable deepCopy(CopyBuilder builder) {
        return builder.deepCopy(this);
    }
}
