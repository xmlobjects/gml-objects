package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.geometry.primitives.SurfaceArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.SurfacePropertyBuilder;
import org.xmlobjects.gml.model.common.Constants;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "MultiSurface", namespaceURI = Constants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "MultiSurface", namespaceURI = Constants.GML_3_1_NAMESPACE_URI)
})
public class MultiSurfaceBuilder extends AbstractGeometricAggregateBuilder<MultiSurface> {

    @Override
    public MultiSurface createObject(QName name) {
        return new MultiSurface();
    }

    @Override
    public void buildNestedObject(MultiSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "surfaceMember":
                object.getSurfaceMember().add(reader.getObjectUsingBuilder(SurfacePropertyBuilder.class));
                break;
            case "surfaceMembers":
                object.setSurfaceMembers(reader.getObjectUsingBuilder(SurfaceArrayPropertyBuilder.class));
                break;
        }
    }
}