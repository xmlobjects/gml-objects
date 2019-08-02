package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.IntegerOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.CountExtent;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CountExtent", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "CountExtent", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class CountExtentAdapter extends IntegerOrNilReasonListAdapter<CountExtent> {

    @Override
    public CountExtent createObject(QName name) {
        return new CountExtent();
    }

    @Override
    public Element createElement(CountExtent object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CountExtent");
    }
}
