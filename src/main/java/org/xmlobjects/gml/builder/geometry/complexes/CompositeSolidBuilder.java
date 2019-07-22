package org.xmlobjects.gml.builder.geometry.complexes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.AttributesBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.AbstractSolidBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.SolidPropertyBuilder;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSolid;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CompositeSolid", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "CompositeSolid", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class CompositeSolidBuilder extends AbstractSolidBuilder<CompositeSolid> {

    @Override
    public CompositeSolid createObject(QName name) {
        return new CompositeSolid();
    }

    @Override
    public void initializeObject(CompositeSolid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        AttributesBuilder.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildNestedObject(CompositeSolid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        if ("solidMember".equals(name.getLocalPart()))
            object.getSolidMembers().add(reader.getObjectUsingBuilder(SolidPropertyBuilder.class));
    }
}
