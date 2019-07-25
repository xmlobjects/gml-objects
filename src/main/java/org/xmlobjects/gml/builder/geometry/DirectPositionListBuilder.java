package org.xmlobjects.gml.builder.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class DirectPositionListBuilder implements ObjectBuilder<DirectPositionList> {

    @Override
    public DirectPositionList createObject(QName name) {
        return new DirectPositionList();
    }

    @Override
    public void initializeObject(DirectPositionList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifDoubleList(object::setValue);
        attributes.getValue("count").ifInteger(object::setCount);
        BuilderHelper.buildSRSReference(object, attributes);
    }
}
