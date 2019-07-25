package org.xmlobjects.gml.builder.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.model.geometry.Vector;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class VectorBuilder implements ObjectBuilder<Vector> {

    @Override
    public Vector createObject(QName name) {
        return new Vector();
    }

    @Override
    public void initializeObject(Vector object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifDoubleList(object::setValue);
        BuilderHelper.buildSRSReference(object, attributes);
    }
}
