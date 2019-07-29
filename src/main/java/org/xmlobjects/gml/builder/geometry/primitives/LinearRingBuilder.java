package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.basictypes.CoordinatesBuilder;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.deprecated.CoordBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionListBuilder;
import org.xmlobjects.gml.model.geometry.GeometricPosition;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;
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
        @XMLElement(name = "LinearRing", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "LinearRing", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class LinearRingBuilder extends AbstractRingBuilder<LinearRing> {

    @Override
    public LinearRing createObject(QName name) {
        return new LinearRing();
    }

    @Override
    public void buildChildObject(LinearRing object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "posList":
                object.getControlPoints().setPosList(reader.getObjectUsingBuilder(DirectPositionListBuilder.class));
                break;
            case "pos":
                object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(DirectPositionBuilder.class)));
                break;
            case "pointProperty":
            case "pointRep":
                object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(PointPropertyBuilder.class)));
                break;
            case "coordinates":
                reader.getObjectUsingBuilder(CoordinatesBuilder.class).toDirectPositions().stream()
                        .map(GeometricPosition::new)
                        .forEach(object.getControlPoints().getGeometricPositions()::add);
                break;
            case "coord":
                object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(CoordBuilder.class).toDirectPosition()));
                break;
        }
    }

    @Override
    public Element createElement(LinearRing object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "LinearRing");
    }

    @Override
    public void writeChildElements(LinearRing object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

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
