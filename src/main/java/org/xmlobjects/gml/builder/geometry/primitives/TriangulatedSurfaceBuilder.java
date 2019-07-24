package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.geometry.primitives.TriangulatedSurface;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "TriangulatedSurface", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "TriangulatedSurface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class TriangulatedSurfaceBuilder extends AbstractSurfaceBuilder<TriangulatedSurface> {

    @Override
    public TriangulatedSurface createObject(QName name) {
        return new TriangulatedSurface();
    }

    @Override
    public void buildChildObject(TriangulatedSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "patches":
            case "trianglePatches":
                object.setPatches(reader.getObjectUsingBuilder(TriangleArrayPropertyBuilder.class));
                break;
        }
    }

    @Override
    public Element createElement(TriangulatedSurface object, Namespaces namespaces) {
        return namespaces.contains(GMLConstants.GML_3_1_NAMESPACE_URI) ?
                Element.of(GMLConstants.GML_3_1_NAMESPACE_URI, "TriangulatedSurface") :
                Element.of(GMLConstants.GML_3_2_NAMESPACE_URI, "TriangulatedSurface");
    }
}
