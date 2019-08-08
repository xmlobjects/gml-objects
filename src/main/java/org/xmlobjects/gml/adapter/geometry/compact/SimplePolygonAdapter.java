package org.xmlobjects.gml.adapter.geometry.compact;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.converter.SimplePolygonConverter;
import org.xmlobjects.gml.model.geometry.compact.SimplePolygon;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "SimplePolygon", namespaceURI = GMLObjects.GML_3_3_CE_NAMESPACE),
        @XMLElement(name = "SimplePolygon", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "SimplePolygon", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class SimplePolygonAdapter extends AbstractSimplePolygonAdapter<SimplePolygon> {

    @Override
    public SimplePolygon createObject(QName name) {
        return new SimplePolygon();
    }

    @Override
    public Element createElement(SimplePolygon object, Namespaces namespaces) {
        return namespaces.contains(GMLObjects.GML_3_3_CE_NAMESPACE) ?
                Element.of(GMLObjects.GML_3_3_CE_NAMESPACE, "SimplePolygon") : null;
    }

    @Override
    public void writeChildElements(SimplePolygon object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (namespaces.contains(GMLObjects.GML_3_3_CE_NAMESPACE))
            super.writeChildElements(object, namespaces, writer);
        else {
            SimplePolygonConverter converter = writer.getProperties().get(SimplePolygonConverter.class.getName(), SimplePolygonConverter.class);
            if (converter != null)
                writer.writeObject(converter.convert(object), namespaces);
        }
    }
}
