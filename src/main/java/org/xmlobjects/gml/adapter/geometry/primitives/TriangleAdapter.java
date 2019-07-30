package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
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
public class TriangleAdapter extends AbstractSurfacePatchAdapter<Triangle> {

    @Override
    public Triangle createObject(QName name) {
        return new Triangle();
    }

    @Override
    public void buildChildObject(Triangle object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI()) && "exterior".equals(name.getLocalPart()))
            object.setExterior(reader.getObjectUsingBuilder(AbstractRingPropertyAdapter.class));
    }

    @Override
    public Element createElement(Triangle object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "Triangle");
    }

    @Override
    public void writeChildElements(Triangle object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getExterior() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "exterior"), object.getExterior(), AbstractRingPropertyAdapter.class, namespaces);
    }
}
