package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.measures.LengthBuilder;
import org.xmlobjects.gml.model.geometry.primitives.Tin;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Tin", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Tin", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class TinBuilder extends AbstractSurfaceBuilder<Tin> {

    @Override
    public Tin createObject(QName name) {
        return new Tin();
    }

    @Override
    public void buildChildObject(Tin object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "patches":
            case "trianglePatches":
                object.setPatches(reader.getObjectUsingBuilder(TriangleArrayPropertyBuilder.class));
                break;
            case "stopLines":
                object.getStopLines().add(reader.getObjectUsingBuilder(LineStringSegmentArrayPropertyBuilder.class));
                break;
            case "breakLines":
                object.getBreakLines().add(reader.getObjectUsingBuilder(LineStringSegmentArrayPropertyBuilder.class));
                break;
            case "maxLength":
                object.setMaxLength(reader.getObjectUsingBuilder(LengthBuilder.class));
                break;
            case "controlPoint":
                object.setControlPoints(reader.getObjectUsingBuilder(TinControlPointsBuilder.class));
                break;
        }
    }
}
