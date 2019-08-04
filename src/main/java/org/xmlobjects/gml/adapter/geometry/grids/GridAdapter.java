package org.xmlobjects.gml.adapter.geometry.grids;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.geometry.grids.Grid;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Grid", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "Grid", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class GridAdapter extends AbstractGridAdapter<Grid> {

    @Override
    public Grid createObject(QName name) {
        return new Grid();
    }

    @Override
    public Element createElement(Grid object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "Grid");
    }
}
