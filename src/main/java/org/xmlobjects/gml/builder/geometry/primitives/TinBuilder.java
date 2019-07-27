package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.geometry.DirectPositionBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionListBuilder;
import org.xmlobjects.gml.builder.measures.LengthBuilder;
import org.xmlobjects.gml.model.geometry.GeometricPosition;
import org.xmlobjects.gml.model.geometry.primitives.LineStringSegmentArrayProperty;
import org.xmlobjects.gml.model.geometry.primitives.Tin;
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

    @Override
    public Element createElement(Tin object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "Tin");
    }

    @Override
    public void writeChildElements(Tin object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        if (object.getPatches() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "trianglePatches"), object.getPatches(), TriangleArrayPropertyBuilder.class, namespaces);

        for (LineStringSegmentArrayProperty property : object.getStopLines())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "stopLines"), property, LineStringSegmentArrayPropertyBuilder.class, namespaces);

        for (LineStringSegmentArrayProperty property : object.getBreakLines())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "breakLines"), property, LineStringSegmentArrayPropertyBuilder.class, namespaces);

        if (object.getMaxLength() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "maxLength"), object.getMaxLength(), LengthBuilder.class, namespaces);

        if (object.getControlPoints().isSetPosList())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "posList"), object.getControlPoints().getPosList(), DirectPositionListBuilder.class, namespaces);
        else if (object.getControlPoints().isSetGeometricPositions()) {
            for (GeometricPosition pos : object.getControlPoints().getGeometricPositions()) {
                if (pos.isSetPos())
                    writer.writeElementUsingSerializer(Element.of(targetNamespace, "pos"), pos.getPos(), DirectPositionBuilder.class, namespaces);
                else if (pos.isSetPointProperty())
                    writer.writeElementUsingSerializer(Element.of(targetNamespace, "pointProperty"), pos.getPointProperty(), PointPropertyBuilder.class, namespaces);
            }
        }
    }
}
