package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.MeasureList;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class MeasureListBuilder implements ObjectBuilder<MeasureList> {

    @Override
    public MeasureList createObject(QName name) {
        return new MeasureList();
    }

    @Override
    public void initializeObject(MeasureList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifDoubleList(object::setValue);
        attributes.getValue("uom").ifPresent(object::setUom);
    }
}
