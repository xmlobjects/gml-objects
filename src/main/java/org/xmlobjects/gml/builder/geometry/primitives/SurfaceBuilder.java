package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.Surface;
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
        @XMLElement(name = "Surface", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Surface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class SurfaceBuilder extends AbstractSurfaceBuilder<Surface> {

    @Override
    public Surface createObject(QName name) {
        return new Surface();
    }

    @Override
    public void buildChildObject(Surface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("patches".equals(name.getLocalPart()))
            object.setPatches(reader.getObjectUsingBuilder(SurfacePatchArrayPropertyBuilder.class));
    }

    @Override
    public Element createElement(Surface object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "Surface");
    }

    @Override
    public void writeChildElements(Surface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getPatches() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "patches"), object.getPatches(), SurfacePatchArrayPropertyBuilder.class, namespaces);
    }
}
