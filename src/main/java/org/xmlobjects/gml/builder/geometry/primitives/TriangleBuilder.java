package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.Triangle;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Triangle", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Triangle", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class TriangleBuilder extends AbstractSurfacePatchBuilder<Triangle> {

    @Override
    public Triangle createObject(QName name) {
        return new Triangle();
    }

    @Override
    public void buildChildObject(Triangle object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if ("exterior".equals(name.getLocalPart()))
            object.setExterior(reader.getObjectUsingBuilder(AbstractRingPropertyBuilder.class));
    }

    @Override
    public Element createElement(Triangle object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "Triangle");
    }

    @Override
    public void writeChildElements(Triangle object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getExterior() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "exterior"), object.getExterior(), AbstractRingPropertyBuilder.class, namespaces);
    }
}
