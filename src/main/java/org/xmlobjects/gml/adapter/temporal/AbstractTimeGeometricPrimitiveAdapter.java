package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.temporal.AbstractTimeGeometricPrimitive;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractTimeGeometricPrimitiveAdapter<T extends AbstractTimeGeometricPrimitive> extends AbstractTimePrimitiveAdapter<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("frame").ifPresent(object::setFrame);
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        if (object.isSetFrame())
            element.addAttribute("frame", object.getFrame());
    }
}
