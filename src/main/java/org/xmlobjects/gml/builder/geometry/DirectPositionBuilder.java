package org.xmlobjects.gml.builder.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class DirectPositionBuilder implements ObjectBuilder<DirectPosition> {

    @Override
    public DirectPosition createObject(QName name) {
        return new DirectPosition();
    }

    @Override
    public void initializeObject(DirectPosition object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifDoubleList(object::setValue);
        BuilderHelper.buildSRSReference(object, attributes);
    }
}
