package org.xmlobjects.gml.adapter.geometry.compact;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.model.geometry.compact.SimpleRectangle;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "SimpleRectangle", namespaceURI = GMLObjects.GML_3_3_CE_NAMESPACE)
public class SimpleRectangleAdapter extends AbstractSimplePolygonAdapter<SimpleRectangle> {

    @Override
    public SimpleRectangle createObject(QName name) {
        return new SimpleRectangle();
    }

    @Override
    public Element createElement(SimpleRectangle object, Namespaces namespaces) {
        return Element.of(GMLObjects.GML_3_3_CE_NAMESPACE, "SimpleRectangle");
    }
}
