package org.xmlobjects.gml.adapter.geometry.complexes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.primitives.AbstractSolidAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSolid;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
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
        @XMLElement(name = "CompositeSolid", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "CompositeSolid", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class CompositeSolidAdapter extends AbstractSolidAdapter<CompositeSolid> {

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
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
            if ("solidMember".equals(name.getLocalPart()))
                object.getSolidMembers().add(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
            else
                super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(CompositeSolid object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CompositeSolid");
    }

    @Override
    public void initializeElement(Element element, CompositeSolid object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        SerializerHelper.serializeAggregationAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(CompositeSolid object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        for (SolidProperty property : object.getSolidMembers())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "solidMember"), property, SolidPropertyAdapter.class, namespaces);
    }
}
