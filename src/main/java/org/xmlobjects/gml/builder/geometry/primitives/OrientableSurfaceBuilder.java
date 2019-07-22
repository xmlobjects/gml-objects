package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.basicTypes.Sign;
import org.xmlobjects.gml.model.geometry.primitives.OrientableSurface;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "OrientableSurface", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "OrientableSurface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class OrientableSurfaceBuilder extends AbstractSurfaceBuilder<OrientableSurface> {

    @Override
    public OrientableSurface createObject(QName name) {
        return new OrientableSurface();
    }

    @Override
    public void initializeObject(OrientableSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("orientation").ifPresent(v -> object.setOrientation(Sign.fromValue(v)));
    }

    @Override
    public void buildNestedObject(OrientableSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        if ("baseSurface".equals(name.getLocalPart()))
            object.setBaseSurface(reader.getObjectUsingBuilder(SurfacePropertyBuilder.class));
    }
}
