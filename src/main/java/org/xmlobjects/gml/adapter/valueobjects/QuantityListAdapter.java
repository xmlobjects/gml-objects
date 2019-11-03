package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.MeasureOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.QuantityList;
import org.xmlobjects.gml.util.GMLConstants;
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
        @XMLElement(name = "QuantityList", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "QuantityList", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class QuantityListAdapter implements ObjectBuilder<QuantityList>, ObjectSerializer<QuantityList> {

    @Override
    public QuantityList createObject(QName name) throws ObjectBuildException {
        return new QuantityList();
    }

    @Override
    public void initializeObject(QuantityList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(MeasureOrNilReasonListAdapter.class).initializeObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(QuantityList object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "QuantityList");
    }

    @Override
    public void initializeElement(Element element, QuantityList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(MeasureOrNilReasonListAdapter.class).initializeElement(element, object, namespaces, writer);
    }
}
