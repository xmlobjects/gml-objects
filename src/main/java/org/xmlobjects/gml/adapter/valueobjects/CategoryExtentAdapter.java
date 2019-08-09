package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CodeOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.CategoryExtent;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CategoryExtent", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "CategoryExtent", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class CategoryExtentAdapter implements ObjectBuilder<CategoryExtent>, ObjectSerializer<CategoryExtent> {

    @Override
    public CategoryExtent createObject(QName name) {
        return new CategoryExtent();
    }

    @Override
    public void initializeObject(CategoryExtent object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(CodeOrNilReasonListAdapter.class).initializeObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CategoryExtent object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CategoryExtent");
    }

    @Override
    public void initializeElement(Element element, CategoryExtent object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(CodeOrNilReasonListAdapter.class).initializeElement(element, object, namespaces, writer);
    }
}
