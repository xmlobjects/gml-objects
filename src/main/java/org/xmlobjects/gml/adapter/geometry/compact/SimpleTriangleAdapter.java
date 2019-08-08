package org.xmlobjects.gml.adapter.geometry.compact;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.converter.SimpleTriangleConverter;
import org.xmlobjects.gml.model.geometry.compact.SimpleTriangle;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "SimpleTriangle", namespaceURI = GMLObjects.GML_3_3_CE_NAMESPACE),
        @XMLElement(name = "SimpleTriangle", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "SimpleTriangle", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class SimpleTriangleAdapter extends AbstractSimplePolygonAdapter<SimpleTriangle> {

    @Override
    public SimpleTriangle createObject(QName name) {
        return new SimpleTriangle();
    }

    @Override
    public Element createElement(SimpleTriangle object, Namespaces namespaces) {
        return namespaces.contains(GMLObjects.GML_3_3_CE_NAMESPACE) ?
                Element.of(GMLObjects.GML_3_3_CE_NAMESPACE, "SimpleTriangle") : null;
    }

    @Override
    public void writeChildElements(SimpleTriangle object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (namespaces.contains(GMLObjects.GML_3_3_CE_NAMESPACE))
            super.writeChildElements(object, namespaces, writer);
        else {
            SimpleTriangleConverter converter = writer.getProperties().get(SimpleTriangleConverter.class.getName(), SimpleTriangleConverter.class);
            if (converter != null)
                writer.writeObject(converter.convert(object), namespaces);
        }
    }
}
