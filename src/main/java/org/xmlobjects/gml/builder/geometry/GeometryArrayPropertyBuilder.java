package org.xmlobjects.gml.builder.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.base.ArrayPropertyBuilder;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class GeometryArrayPropertyBuilder<T extends GeometryArrayProperty> extends ArrayPropertyBuilder<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) {
        return (T) new GeometryArrayProperty<>();
    }

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuilderHelper.buildOwnershipAttributes(object, attributes);
    }
}
