package org.xmlobjects.gml.adapter.geometry.complexes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.primitives.AbstractSurfaceAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SurfacePropertyAdapter;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
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
        @XMLElement(name = "CompositeSurface", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "CompositeSurface", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class CompositeSurfaceAdapter extends AbstractSurfaceAdapter<CompositeSurface> {

    @Override
    public CompositeSurface createObject(QName name) {
        return new CompositeSurface();
    }

    @Override
    public void initializeObject(CompositeSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        BuilderHelper.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(CompositeSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            if ("surfaceMember".equals(name.getLocalPart()))
                object.getSurfaceMembers().add(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class));
            else
                super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(CompositeSurface object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CompositeSurface");
    }

    @Override
    public void initializeElement(Element element, CompositeSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        SerializerHelper.serializeAggregationAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(CompositeSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        for (SurfaceProperty property : object.getSurfaceMembers())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "surfaceMember"), property, SurfacePropertyAdapter.class, namespaces);
    }
}
