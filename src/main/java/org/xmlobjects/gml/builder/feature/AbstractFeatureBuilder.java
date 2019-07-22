package org.xmlobjects.gml.builder.feature;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.base.AbstractGMLBuilder;
import org.xmlobjects.gml.builder.deprecatedTypes.LocationPropertyBuilder;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractFeatureBuilder<T extends AbstractFeature> extends AbstractGMLBuilder<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "boundedBy":
                object.setBoundedBy(reader.getObjectUsingBuilder(BoundingShapeBuilder.class));
                break;
            case "location":
                object.setLocation(reader.getObjectUsingBuilder(LocationPropertyBuilder.class));
                break;
        }
    }
}
