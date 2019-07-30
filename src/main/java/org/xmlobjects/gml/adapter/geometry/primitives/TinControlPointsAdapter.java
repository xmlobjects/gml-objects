package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.DirectPositionAdapter;
import org.xmlobjects.gml.adapter.geometry.DirectPositionListAdapter;
import org.xmlobjects.gml.model.geometry.GeometricPosition;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class TinControlPointsAdapter implements ObjectBuilder<GeometricPositionList> {

    @Override
    public GeometricPositionList createObject(QName name) {
        return new GeometricPositionList();
    }

    @Override
    public void buildChildObject(GeometricPositionList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "posList":
                object.setPosList(reader.getObjectUsingBuilder(DirectPositionListAdapter.class));
                break;
            case "pos":
                object.getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(DirectPositionAdapter.class)));
                break;
            case "pointProperty":
                object.getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(PointPropertyAdapter.class)));
                break;
        }
    }
}
