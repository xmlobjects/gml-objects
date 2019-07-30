package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.common.SerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.TriangulatedSurface;
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
        @XMLElement(name = "TriangulatedSurface", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "TriangulatedSurface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class TriangulatedSurfaceAdapter extends AbstractSurfaceAdapter<TriangulatedSurface> {

    @Override
    public TriangulatedSurface createObject(QName name) {
        return new TriangulatedSurface();
    }

    @Override
    public void buildChildObject(TriangulatedSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "patches":
            case "trianglePatches":
                object.setPatches(reader.getObjectUsingBuilder(TriangleArrayPropertyAdapter.class));
                break;
        }
    }

    @Override
    public Element createElement(TriangulatedSurface object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "TriangulatedSurface");
    }

    @Override
    public void writeChildElements(TriangulatedSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getPatches() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "trianglePatches"), object.getPatches(), TriangleArrayPropertyAdapter.class, namespaces);
    }
}
