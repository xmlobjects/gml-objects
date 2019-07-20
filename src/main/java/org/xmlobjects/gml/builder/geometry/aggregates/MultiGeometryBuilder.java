package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.geometry.GeometryArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.common.Constants;
import org.xmlobjects.gml.model.geometry.aggregates.MultiGeometry;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "MultiGeometry", namespaceURI = Constants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "MultiGeometry", namespaceURI = Constants.GML_3_1_NAMESPACE_URI)
})
public class MultiGeometryBuilder extends AbstractGeometricAggregateBuilder<MultiGeometry> {

    @Override
    public MultiGeometry createObject(QName name) {
        return new MultiGeometry();
    }

    @Override
    public void buildNestedObject(MultiGeometry object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "geometryMember":
                object.getGeometryMember().add(reader.getObjectUsingBuilder(new GeometryPropertyBuilder<>()));
                break;
            case "geometryMembers":
                object.setGeometryMembers(reader.getObjectUsingBuilder((new GeometryArrayPropertyBuilder<>())));
                break;
        }
    }
}
