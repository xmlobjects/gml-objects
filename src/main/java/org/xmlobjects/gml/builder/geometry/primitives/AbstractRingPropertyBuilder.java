package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.geometry.primitives.AbstractRing;
import org.xmlobjects.gml.model.geometry.primitives.AbstractRingProperty;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class AbstractRingPropertyBuilder implements ObjectBuilder<AbstractRingProperty> {

    @Override
    public AbstractRingProperty createObject(QName name) {
        return new AbstractRingProperty();
    }

    @Override
    public void buildChildObject(AbstractRingProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getObject(AbstractRing.class).ifObject(object::setObject);
    }
}
