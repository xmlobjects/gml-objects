package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.common.Constants;
import org.xmlobjects.gml.model.geometry.primitives.Surface;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Surface", namespaceURI = Constants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Surface", namespaceURI = Constants.GML_3_1_NAMESPACE_URI)
})
public class SurfaceBuilder extends AbstractSurfaceBuilder<Surface> {

    @Override
    public Surface createObject(QName name) {
        return new Surface();
    }

    @Override
    public void buildNestedObject(Surface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        if ("patches".equals(name.getLocalPart()))
            object.setPatches(reader.getObjectUsingBuilder(SurfacePatchArrayPropertyBuilder.class));
    }
}
