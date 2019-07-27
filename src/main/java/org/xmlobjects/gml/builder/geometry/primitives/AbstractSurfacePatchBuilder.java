package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurfacePatch;
import org.xmlobjects.serializer.ObjectSerializer;

public abstract class AbstractSurfacePatchBuilder<T extends AbstractSurfacePatch> implements ObjectBuilder<T>, ObjectSerializer<T> {
}
