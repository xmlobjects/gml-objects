package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.geometry.primitives.Triangle;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Triangle", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Triangle", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
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
}
