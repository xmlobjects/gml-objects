package org.xmlobjects.gml.builder.geometry;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.basicTypes.CoordinatesBuilder;
import org.xmlobjects.gml.builder.common.AttributesBuilder;
import org.xmlobjects.gml.builder.deprecatedTypes.CoordBuilder;
import org.xmlobjects.gml.model.deprecatedTypes.Coord;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;
import java.util.List;

@XMLElements({
        @XMLElement(name = "Envelope", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Envelope", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class EnvelopeBuilder implements ObjectBuilder<Envelope> {

    @Override
    public Envelope createObject(QName name) {
        return new Envelope();
    }

    @Override
    public void initializeObject(Envelope object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        AttributesBuilder.buildSRSReference(object, attributes);
    }

    @Override
    public void buildChildObject(Envelope object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "lowerCorner":
                object.setLowerCorner(reader.getObjectUsingBuilder(DirectPositionBuilder.class));
                break;
            case "upperCorner":
                object.setUpperCorner(reader.getObjectUsingBuilder(DirectPositionBuilder.class));
                break;
            case "pos":
                DirectPosition pos = reader.getObjectUsingBuilder(DirectPositionBuilder.class);
                if (object.getLowerCorner() == null)
                    object.setLowerCorner(pos);
                else if (object.getUpperCorner() == null)
                    object.setUpperCorner(pos);
                break;
            case "coordinates":
                List<DirectPosition> positions = reader.getObjectUsingBuilder(CoordinatesBuilder.class).toDirectPositions();
                if (positions.size() > 1) {
                    object.setLowerCorner(positions.get(0));
                    object.setUpperCorner(positions.get(1));
                }
                break;
            case "coord":
                Coord coord = reader.getObjectUsingBuilder(CoordBuilder.class);
                if (object.getLowerCorner() == null)
                    object.setLowerCorner(coord.toDirectPosition());
                else if (object.getUpperCorner() == null)
                    object.setUpperCorner(coord.toDirectPosition());
                break;
        }
    }
}
