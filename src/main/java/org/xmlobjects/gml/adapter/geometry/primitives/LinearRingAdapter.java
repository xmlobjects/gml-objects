package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CoordinatesAdapter;
import org.xmlobjects.gml.adapter.deprecated.CoordAdapter;
import org.xmlobjects.gml.adapter.geometry.DirectPositionAdapter;
import org.xmlobjects.gml.adapter.geometry.DirectPositionListAdapter;
import org.xmlobjects.gml.adapter.geometry.GeometricPositionListAdapter;
import org.xmlobjects.gml.model.geometry.GeometricPosition;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "LinearRing", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "LinearRing", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class LinearRingAdapter extends AbstractRingAdapter<LinearRing> {

    @Override
    public LinearRing createObject(QName name) {
        return new LinearRing();
    }

    @Override
    public void buildChildObject(LinearRing object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
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
                case "coord":
                    object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(CoordAdapter.class).toDirectPosition()));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(LinearRing object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "LinearRing");
    }

    @Override
    public void writeChildElements(LinearRing object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        writer.getOrCreateSerializer(GeometricPositionListAdapter.class).writeChildElements(object.getControlPoints(), namespaces, writer);
    }
}
