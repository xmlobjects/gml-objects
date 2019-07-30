package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.common.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.DirectPositionAdapter;
import org.xmlobjects.gml.adapter.geometry.DirectPositionListAdapter;
import org.xmlobjects.gml.adapter.measures.LengthAdapter;
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
        @XMLElement(name = "Tin", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Tin", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class TinAdapter extends AbstractSurfaceAdapter<Tin> {

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
                object.setPatches(reader.getObjectUsingBuilder(TriangleArrayPropertyAdapter.class));
                break;
            case "stopLines":
                object.getStopLines().add(reader.getObjectUsingBuilder(LineStringSegmentArrayPropertyAdapter.class));
                break;
            case "breakLines":
                object.getBreakLines().add(reader.getObjectUsingBuilder(LineStringSegmentArrayPropertyAdapter.class));
                break;
            case "maxLength":
                object.setMaxLength(reader.getObjectUsingBuilder(LengthAdapter.class));
                break;
            case "controlPoint":
                object.setControlPoints(reader.getObjectUsingBuilder(TinControlPointsAdapter.class));
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
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "trianglePatches"), object.getPatches(), TriangleArrayPropertyAdapter.class, namespaces);

        for (LineStringSegmentArrayProperty property : object.getStopLines())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "stopLines"), property, LineStringSegmentArrayPropertyAdapter.class, namespaces);

        for (LineStringSegmentArrayProperty property : object.getBreakLines())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "breakLines"), property, LineStringSegmentArrayPropertyAdapter.class, namespaces);

        if (object.getMaxLength() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "maxLength"), object.getMaxLength(), LengthAdapter.class, namespaces);

        if (object.getControlPoints().isSetPosList())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "posList"), object.getControlPoints().getPosList(), DirectPositionListAdapter.class, namespaces);
        else if (object.getControlPoints().isSetGeometricPositions()) {
            for (GeometricPosition pos : object.getControlPoints().getGeometricPositions()) {
                if (pos.isSetPos())
                    writer.writeElementUsingSerializer(Element.of(targetNamespace, "pos"), pos.getPos(), DirectPositionAdapter.class, namespaces);
                else if (pos.isSetPointProperty())
                    writer.writeElementUsingSerializer(Element.of(targetNamespace, "pointProperty"), pos.getPointProperty(), PointPropertyAdapter.class, namespaces);
            }
        }
    }
}
