package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.geometry.primitives.AbstractCurveSegment;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public abstract class AbstractCurveSegmentAdapter<T extends AbstractCurveSegment> implements ObjectBuilder<T>, ObjectSerializer<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) {
        attributes.getValue("numDerivativesAtStart").ifInteger(object::setNumDerivativesAtStart);
        attributes.getValue("numDerivativesAtEnd").ifInteger(object::setNumDerivativesAtEnd);
        attributes.getValue("numDerivativeInterior").ifInteger(object::setNumDerivativeInterior);
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) {
        if (object.getNumDerivativesAtStart() != 0)
            element.addAttribute("numDerivativesAtStart", TextContent.ofInteger(object.getNumDerivativesAtStart()));

        if (object.getNumDerivativesAtEnd() != 0)
            element.addAttribute("numDerivativesAtEnd", TextContent.ofInteger(object.getNumDerivativesAtEnd()));

        if (object.getNumDerivativeInterior() != 0)
            element.addAttribute("numDerivativeInterior", TextContent.ofInteger(object.getNumDerivativeInterior()));
    }
}
