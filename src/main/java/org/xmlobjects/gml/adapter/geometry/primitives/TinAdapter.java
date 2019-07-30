package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
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
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
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
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(Tin object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "Tin");
    }

    @Override
    public void writeChildElements(Tin object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getPatches() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "trianglePatches"), object.getPatches(), TriangleArrayPropertyAdapter.class, namespaces);

        for (LineStringSegmentArrayProperty property : object.getStopLines())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "stopLines"), property, LineStringSegmentArrayPropertyAdapter.class, namespaces);

        for (LineStringSegmentArrayProperty property : object.getBreakLines())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "breakLines"), property, LineStringSegmentArrayPropertyAdapter.class, namespaces);

        if (object.getMaxLength() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "maxLength"), object.getMaxLength(), LengthAdapter.class, namespaces);

        if (object.getControlPoints().isSetPosList())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "posList"), object.getControlPoints().getPosList(), DirectPositionListAdapter.class, namespaces);
        else if (object.getControlPoints().isSetGeometricPositions()) {
            for (GeometricPosition pos : object.getControlPoints().getGeometricPositions()) {
                if (pos.isSetPos())
                    writer.writeElementUsingSerializer(Element.of(baseNamespace, "pos"), pos.getPos(), DirectPositionAdapter.class, namespaces);
                else if (pos.isSetPointProperty())
                    writer.writeElementUsingSerializer(Element.of(baseNamespace, "pointProperty"), pos.getPointProperty(), PointPropertyAdapter.class, namespaces);
            }
        }
    }
}
