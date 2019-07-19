package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.geometry.primitives.AbstractCurveSegment;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractCurveSegmentBuilder<T extends AbstractCurveSegment> implements ObjectBuilder<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        attributes.getValue("numDerivativesAtStart").ifInteger(object::setNumDerivativesAtStart);
        attributes.getValue("numDerivativesAtEnd").ifInteger(object::setNumDerivativesAtEnd);
        attributes.getValue("numDerivativeInterior").ifInteger(object::setNumDerivativeInterior);
    }
}
