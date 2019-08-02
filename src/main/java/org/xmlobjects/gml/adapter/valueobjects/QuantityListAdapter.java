package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.MeasureOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.QuantityList;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "QuantityList", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "QuantityList", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class QuantityListAdapter extends MeasureOrNilReasonListAdapter<QuantityList> {

    @Override
    public QuantityList createObject(QName name) {
        return new QuantityList();
    }

    @Override
    public Element createElement(QuantityList object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "QuantityList");
    }
}
