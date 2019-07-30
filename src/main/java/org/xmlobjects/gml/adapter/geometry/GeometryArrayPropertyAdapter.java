package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.base.ArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class GeometryArrayPropertyAdapter<T extends GeometryArrayProperty> extends ArrayPropertyAdapter<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) {
        return (T) new GeometryArrayProperty<>();
    }

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) {
        BuilderHelper.buildOwnershipAttributes(object, attributes);
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) {
        SerializerHelper.serializeOwnershipAttributes(element, object, namespaces);
    }
}
