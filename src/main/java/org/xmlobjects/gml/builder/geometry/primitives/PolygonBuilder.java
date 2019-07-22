package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.geometry.primitives.Polygon;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Polygon", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Polygon", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class PolygonBuilder extends AbstractSurfaceBuilder<Polygon> {

    @Override
    public Polygon createObject(QName name) {
        return new Polygon();
    }

    @Override
    public void buildChildObject(Polygon object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "exterior":
            case "outerBoundaryIs":
                object.setExterior(reader.getObjectUsingBuilder(AbstractRingPropertyBuilder.class));
                break;
            case "interior":
            case "innerBoundaryIs":
                object.getInterior().add(reader.getObjectUsingBuilder(AbstractRingPropertyBuilder.class));
                break;
        }
    }
}
