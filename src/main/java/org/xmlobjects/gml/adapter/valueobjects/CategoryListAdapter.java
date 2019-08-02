package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CodeOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.CategoryList;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CategoryList", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "CategoryList", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class CategoryListAdapter extends CodeOrNilReasonListAdapter<CategoryList> {

    @Override
    public CategoryList createObject(QName name) {
        return new CategoryList();
    }

    @Override
    public Element createElement(CategoryList object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CategoryList");
    }
}
