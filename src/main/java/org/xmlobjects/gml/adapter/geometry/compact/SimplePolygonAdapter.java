package org.xmlobjects.gml.adapter.geometry.compact;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.model.geometry.compact.SimplePolygon;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "SimplePolygon", namespaceURI = GMLObjects.GML_3_3_CE_NAMESPACE)
public class SimplePolygonAdapter extends AbstractSimplePolygonAdapter<SimplePolygon> {

    @Override
    public SimplePolygon createObject(QName name) {
        return new SimplePolygon();
    }

    @Override
    public Element createElement(SimplePolygon object, Namespaces namespaces) {
        return Element.of(GMLObjects.GML_3_3_CE_NAMESPACE, "SimplePolygon");
    }
}
