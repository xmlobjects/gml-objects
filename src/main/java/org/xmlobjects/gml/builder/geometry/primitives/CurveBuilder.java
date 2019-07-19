package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.common.Constants;
import org.xmlobjects.gml.model.geometry.primitives.Curve;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Curve", namespaceURI = Constants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Curve", namespaceURI = Constants.GML_3_1_NAMESPACE_URI)
})
public class CurveBuilder extends AbstractCurveBuilder<Curve> {

    @Override
    public Curve createObject(QName name) {
        return new Curve();
    }

    @Override
    public void buildNestedObject(Curve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        if ("segments".equals(name.getLocalPart()))
            object.setSegments(reader.getObjectUsingBuilder(CurveSegmentArrayPropertyBuilder.class));
    }
}
