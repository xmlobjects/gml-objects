package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.PolyhedralSurface;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "PolyhedralSurface", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "PolyhedralSurface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class PolyhedralSurfaceAdapter extends AbstractSurfaceAdapter<PolyhedralSurface> {

    @Override
    public PolyhedralSurface createObject(QName name) {
        return new PolyhedralSurface();
    }

    @Override
    public void buildChildObject(PolyhedralSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "patches":
                case "polygonPatches":
                    object.setPatches(reader.getObjectUsingBuilder(PolygonPatchArrayPropertyAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(PolyhedralSurface object, Namespaces namespaces) {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "PolyhedralSurface");
    }

    @Override
    public void writeChildElements(PolyhedralSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getPatches() != null)
            writer.writeElementUsingSerializer(Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "polygonPatches"), object.getPatches(), PolygonPatchArrayPropertyAdapter.class, namespaces);
    }
}
