package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.MeasureOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.QuantityExtent;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "QuantityExtent", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "QuantityExtent", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class QuantityExtentAdapter extends MeasureOrNilReasonListAdapter<QuantityExtent> {

    @Override
    public QuantityExtent createObject(QName name) {
        return new QuantityExtent();
    }

    @Override
    public Element createElement(QuantityExtent object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "QuantityExtent");
    }
}
