package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.Surface;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Surface", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "Surface", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class SurfaceAdapter extends AbstractSurfaceAdapter<Surface> {

    @Override
    public Surface createObject(QName name, Properties properties) {
        return new Surface();
    }

    @Override
    public void buildChildObject(Surface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            if ("patches".equals(name.getLocalPart()))
                object.setPatches(reader.getObjectUsingBuilder(SurfacePatchArrayPropertyAdapter.class));
            else
                super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(Surface object, Namespaces namespaces, Properties properties) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "Surface");
    }

    @Override
    public void writeChildElements(Surface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getPatches() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "patches"), object.getPatches(), SurfacePatchArrayPropertyAdapter.class, namespaces);
    }
}
