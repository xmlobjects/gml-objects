package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.geometry.primitives.PolygonPatch;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "PolygonPatch", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "PolygonPatch", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class PolygonPatchBuilder extends AbstractSurfacePatchBuilder<PolygonPatch> {

    @Override
    public PolygonPatch createObject(QName name) {
        return new PolygonPatch();
    }

    @Override
    public void buildNestedObject(PolygonPatch object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "exterior":
                object.setExterior(reader.getObjectUsingBuilder(AbstractRingPropertyBuilder.class));
                break;
            case "interior":
                object.getInterior().add(reader.getObjectUsingBuilder(AbstractRingPropertyBuilder.class));
                break;
        }
    }
}
