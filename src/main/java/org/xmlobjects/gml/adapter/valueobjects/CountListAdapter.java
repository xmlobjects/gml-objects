package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.IntegerOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.CountList;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CountList", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "CountList", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class CountListAdapter extends IntegerOrNilReasonListAdapter<CountList> {

    @Override
    public CountList createObject(QName name) {
        return new CountList();
    }

    @Override
    public Element createElement(CountList object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CountList");
    }
}
