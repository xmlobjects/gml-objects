package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CodeOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.CategoryList;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
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
        @XMLElement(name = "CategoryList", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "CategoryList", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class CategoryListAdapter implements ObjectBuilder<CategoryList>, ObjectSerializer<CategoryList> {

    @Override
    public CategoryList createObject(QName name, Properties properties) {
        return new CategoryList();
    }

    @Override
    public void initializeObject(CategoryList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(CodeOrNilReasonListAdapter.class).initializeObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CategoryList object, Namespaces namespaces, Properties properties) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CategoryList");
    }

    @Override
    public void initializeElement(Element element, CategoryList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(CodeOrNilReasonListAdapter.class).initializeElement(element, object, namespaces, writer);
    }
}
