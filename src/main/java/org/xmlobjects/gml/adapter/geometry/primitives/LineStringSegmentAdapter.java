package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CoordinatesAdapter;
import org.xmlobjects.gml.adapter.geometry.DirectPositionAdapter;
import org.xmlobjects.gml.adapter.geometry.DirectPositionListAdapter;
import org.xmlobjects.gml.model.geometry.GeometricPosition;
import org.xmlobjects.gml.model.geometry.primitives.LineStringSegment;
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
        @XMLElement(name = "LineStringSegment", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "LineStringSegment", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class LineStringSegmentAdapter extends AbstractCurveSegmentAdapter<LineStringSegment> {

    @Override
    public LineStringSegment createObject(QName name) {
        return new LineStringSegment();
    }

    @Override
    public void buildChildObject(LineStringSegment object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "posList":
                    object.getControlPoints().setPosList(reader.getObjectUsingBuilder(DirectPositionListAdapter.class));
                    break;
                case "pos":
                    object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(DirectPositionAdapter.class)));
                    break;
                case "pointProperty":
                case "pointRep":
                    object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(PointPropertyAdapter.class)));
                    break;
                case "coordinates":
                    reader.getObjectUsingBuilder(CoordinatesAdapter.class).toDirectPositions().stream()
                            .map(GeometricPosition::new)
                            .forEach(object.getControlPoints().getGeometricPositions()::add);
                    break;
            }
        }
    }

    @Override
    public Element createElement(LineStringSegment object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "LineStringSegment");
    }

    @Override
    public void writeChildElements(LineStringSegment object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

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
