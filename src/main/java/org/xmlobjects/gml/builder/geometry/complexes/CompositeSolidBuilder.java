package org.xmlobjects.gml.builder.geometry.complexes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.geometry.primitives.AbstractSolidBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.SolidPropertyBuilder;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSolid;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
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
        BuilderHelper.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(CompositeSolid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("solidMember".equals(name.getLocalPart()))
            object.getSolidMembers().add(reader.getObjectUsingBuilder(SolidPropertyBuilder.class));
    }

    @Override
    public Element createElement(CompositeSolid object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "CompositeSolid");
    }

    @Override
    public void initializeElement(Element element, CompositeSolid object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        SerializerHelper.serializeAggregationAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(CompositeSolid object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        for (SolidProperty property : object.getSolidMembers())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "solidMember"), property, SolidPropertyBuilder.class, namespaces);
    }
}
