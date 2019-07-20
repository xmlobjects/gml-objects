package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.Measure;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class MeasureBuilder<T extends Measure> implements ObjectBuilder<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) {
        return (T) new Measure();
    }

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifDouble(object::setValue);
        attributes.getValue("uom").ifPresent(object::setUom);
    }

    @Override
    public void buildNestedObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
    }
}
