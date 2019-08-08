package org.xmlobjects.gml.adapter.geometry.compact;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.model.geometry.compact.SimpleTriangle;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "SimpleTriangle", namespaceURI = GMLObjects.GML_3_3_CE_NAMESPACE)
public class SimpleTriangleAdapter extends AbstractSimplePolygonAdapter<SimpleTriangle> {

    @Override
    public SimpleTriangle createObject(QName name, Properties properties) {
        return new SimpleTriangle();
    }

    @Override
    public Element createElement(SimpleTriangle object, Namespaces namespaces, Properties properties) {
        return Element.of(GMLObjects.GML_3_3_CE_NAMESPACE, "SimpleTriangle");
    }
}
