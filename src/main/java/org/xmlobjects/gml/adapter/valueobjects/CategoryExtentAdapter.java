package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CodeOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.CategoryExtent;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CategoryExtent", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "CategoryExtent", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class CategoryExtentAdapter extends CodeOrNilReasonListAdapter<CategoryExtent> {

    @Override
    public CategoryExtent createObject(QName name) {
        return new CategoryExtent();
    }

    @Override
    public Element createElement(CategoryExtent object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CategoryExtent");
    }
}
