package org.xmlobjects.gml.adapter.geometry.compact;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.converter.SimpleRectangleConverter;
import org.xmlobjects.gml.model.geometry.compact.SimpleRectangle;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "SimpleRectangle", namespaceURI = GMLConstants.GML_3_3_CE_NAMESPACE),
        @XMLElement(name = "SimpleRectangle", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "SimpleRectangle", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class SimpleRectangleAdapter extends AbstractSimplePolygonAdapter<SimpleRectangle> {

    @Override
    public SimpleRectangle createObject(QName name) {
        return new SimpleRectangle();
    }

    @Override
    public Element createElement(SimpleRectangle object, Namespaces namespaces) {
        return namespaces.contains(GMLConstants.GML_3_3_CE_NAMESPACE) ?
                Element.of(GMLConstants.GML_3_3_CE_NAMESPACE, "SimpleRectangle") : null;
    }

    @Override
    public void writeChildElements(SimpleRectangle object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (namespaces.contains(GMLConstants.GML_3_3_CE_NAMESPACE))
            super.writeChildElements(object, namespaces, writer);
        else {
            SimpleRectangleConverter converter = writer.getProperties().get(SimpleRectangleConverter.class.getName(), SimpleRectangleConverter.class);
            if (converter != null)
                writer.writeObject(converter.convert(object), namespaces);
        }
    }
}
