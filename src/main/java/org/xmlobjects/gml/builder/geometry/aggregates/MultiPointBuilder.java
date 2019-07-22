package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.geometry.primitives.PointArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.PointPropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "MultiPoint", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "MultiPoint", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class MultiPointBuilder extends AbstractGeometricAggregateBuilder<MultiPoint> {

    @Override
    public MultiPoint createObject(QName name) {
        return new MultiPoint();
    }

    @Override
    public void buildNestedObject(MultiPoint object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "pointMember":
                object.getPointMember().add(reader.getObjectUsingBuilder(PointPropertyBuilder.class));
                break;
            case "pointMembers":
                object.setPointMembers(reader.getObjectUsingBuilder(PointArrayPropertyBuilder.class));
                break;
        }
    }
}
