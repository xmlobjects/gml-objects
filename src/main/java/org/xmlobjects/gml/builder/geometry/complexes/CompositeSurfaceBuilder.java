package org.xmlobjects.gml.builder.geometry.complexes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.geometry.primitives.AbstractSurfaceBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.SurfacePropertyBuilder;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CompositeSurface", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "CompositeSurface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class CompositeSurfaceBuilder extends AbstractSurfaceBuilder<CompositeSurface> {

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
        super.buildChildObject(object, name, attributes, reader);

        if ("surfaceMember".equals(name.getLocalPart()))
            object.getSurfaceMembers().add(reader.getObjectUsingBuilder(SurfacePropertyBuilder.class));
    }

    @Override
    public Element createElement(CompositeSurface object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "CompositeSurface");
    }
}
