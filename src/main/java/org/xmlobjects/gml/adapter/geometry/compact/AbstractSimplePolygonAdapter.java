package org.xmlobjects.gml.adapter.geometry.compact;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.gml.adapter.geometry.DirectPositionAdapter;
import org.xmlobjects.gml.adapter.geometry.DirectPositionListAdapter;
import org.xmlobjects.gml.adapter.geometry.GeometricPositionListAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.AbstractSurfaceAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.PointPropertyAdapter;
import org.xmlobjects.gml.model.geometry.GeometricPosition;
import org.xmlobjects.gml.model.geometry.compact.AbstractSimplePolygon;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractSimplePolygonAdapter<T extends AbstractSimplePolygon> extends AbstractSurfaceAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLConstants.GML_3_2_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "posList":
                    object.getControlPoints().setPosList(reader.getObjectUsingBuilder(DirectPositionListAdapter.class));
                    break;
                case "pos":
                    object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(DirectPositionAdapter.class)));
                    break;
                case "pointProperty":
                    object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(PointPropertyAdapter.class)));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        writer.getOrCreateSerializer(GeometricPositionListAdapter.class).writeChildElements(object.getControlPoints(), namespaces, writer);
    }
}
