package org.xmlobjects.gml.builder.feature;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.basicTypes.NilReasonBuilder;
import org.xmlobjects.gml.builder.geometry.EnvelopeBuilder;
import org.xmlobjects.gml.model.basicTypes.NilReason;
import org.xmlobjects.gml.model.feature.BoundingShape;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class BoundingShapeBuilder implements ObjectBuilder<BoundingShape> {

    @Override
    public BoundingShape createObject(QName name) {
        return new BoundingShape();
    }

    @Override
    public void initializeObject(BoundingShape object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        attributes.getValue("nilReason").ifPresent(v -> object.setNilReason(new NilReason(v)));
    }

    @Override
    public void buildChildObject(BoundingShape object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "Envelope":
                object.setEnvelope(reader.getObjectUsingBuilder(EnvelopeBuilder.class));
                break;
            case "Null":
                if (object.getNilReason() == null || object.getNilReason().getValue() == null)
                    object.setNilReason(reader.getObjectUsingBuilder(NilReasonBuilder.class));
                break;
        }
    }
}
