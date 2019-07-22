package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.geometry.primitives.PolyhedralSurface;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "PolyhedralSurface", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "PolyhedralSurface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class PolyhedralSurfaceBuilder extends AbstractSurfaceBuilder<PolyhedralSurface> {

    @Override
    public PolyhedralSurface createObject(QName name) {
        return new PolyhedralSurface();
    }

    @Override
    public void buildChildObject(PolyhedralSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "patches":
            case "polygonPatches":
                object.setPatches(reader.getObjectUsingBuilder(PolygonPatchArrayPropertyBuilder.class));
                break;
        }
    }
}
