package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.coverage.IncrementOrder;
import org.xmlobjects.gml.model.coverage.SequenceRule;
import org.xmlobjects.gml.model.coverage.SequenceRuleEnumeration;
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
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class SequenceRuleAdapter implements ObjectBuilder<SequenceRule>, ObjectSerializer<SequenceRule> {

    @Override
    public SequenceRule createObject(QName name) {
        return new SequenceRule();
    }

    @Override
    public void initializeObject(SequenceRule object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifPresent(v -> object.setValue(SequenceRuleEnumeration.fromValue(v)));
        attributes.getValue("order").ifPresent(v -> object.setAxisOrders(IncrementOrder.fromValue(v)));
        attributes.getValue("axisOrder").ifList(object::setAxisOrders);
    }

    @Override
    public void initializeElement(Element element, SequenceRule object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addTextContent(object.getValue().toValue());

        if (!object.getAxisOrders().isEmpty()) {
            if (GMLObjects.GML_3_2_NAMESPACE.equals(SerializerHelper.getGMLBaseNamespace(namespaces)))
                element.addAttribute("axisOrder", TextContent.ofList(object.getAxisOrders()));
            else {
                IncrementOrder order = IncrementOrder.fromAxisOrders(object.getAxisOrders());
                if (order != null)
                    element.addAttribute("order", order.toValue());
            }
        }
    }
}
