package org.xmlobjects.gml.converter;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.serializer.ObjectSerializeException;

public interface GMLObjectConverter<T extends GMLObject, R extends GMLObject> {
    R convert(T object) throws ObjectSerializeException;
}
