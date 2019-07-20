package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionListBuilder;
import org.xmlobjects.gml.model.geometry.GeometricPosition;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class TinControlPointsBuilder implements ObjectBuilder<GeometricPositionList> {

    @Override
    public GeometricPositionList createObject(QName name) {
        return new GeometricPositionList();
    }

    @Override
    public void initializeObject(GeometricPositionList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
    }

    @Override
    public void buildNestedObject(GeometricPositionList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "posList":
                object.setPosList(reader.getObjectUsingBuilder(DirectPositionListBuilder.class));
                break;
            case "pos":
                object.getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(DirectPositionBuilder.class)));
                break;
            case "pointProperty":
                object.getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(PointPropertyBuilder.class)));
                break;
        }
    }
}
