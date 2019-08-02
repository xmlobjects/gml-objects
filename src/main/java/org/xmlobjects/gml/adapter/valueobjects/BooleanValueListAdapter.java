package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.BooleanOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.BooleanValueList;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "BooleanList", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "BooleanList", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class BooleanValueListAdapter extends BooleanOrNilReasonListAdapter<BooleanValueList> {

    @Override
    public BooleanValueList createObject(QName name) {
        return new BooleanValueList();
    }

    @Override
    public Element createElement(BooleanValueList object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "BooleanList");
    }
}
