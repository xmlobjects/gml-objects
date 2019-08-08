package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.valueobjects.CompositeValue;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CompositeValue", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "CompositeValue", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class CompositeValueAdapter extends AbstractCompositeValueAdapter<CompositeValue> {

    @Override
    public CompositeValue createObject(QName name) {
        return new CompositeValue();
    }

    @Override
    public Element createElement(CompositeValue object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CompositeValue");
    }
}
