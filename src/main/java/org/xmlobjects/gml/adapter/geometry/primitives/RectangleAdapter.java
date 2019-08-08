package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.Rectangle;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Rectangle", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "Rectangle", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class RectangleAdapter extends AbstractSurfacePatchAdapter<Rectangle> {

    @Override
    public Rectangle createObject(QName name) {
        return new Rectangle();
    }

    @Override
    public void buildChildObject(Rectangle object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI()) && "exterior".equals(name.getLocalPart()))
            object.setExterior(reader.getObjectUsingBuilder(AbstractRingPropertyAdapter.class));
    }

    @Override
    public Element createElement(Rectangle object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "Rectangle");
    }

    @Override
    public void writeChildElements(Rectangle object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getExterior() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "exterior"), object.getExterior(), AbstractRingPropertyAdapter.class, namespaces);
    }
}
