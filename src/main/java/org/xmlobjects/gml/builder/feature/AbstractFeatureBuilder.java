package org.xmlobjects.gml.builder.feature;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.base.AbstractGMLBuilder;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.deprecatedTypes.LocationPropertyBuilder;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractFeatureBuilder<T extends AbstractFeature> extends AbstractGMLBuilder<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "boundedBy":
                object.setBoundedBy(reader.getObjectUsingBuilder(BoundingShapeBuilder.class));
                break;
            case "location":
                object.setLocation(reader.getObjectUsingBuilder(LocationPropertyBuilder.class));
                break;
        }
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        if (object.getBoundedBy() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "boundedBy"), object.getBoundedBy(), BoundingShapeBuilder.class, namespaces);

        if (object.getLocation() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "location"), object.getLocation(), LocationPropertyBuilder.class, namespaces);
    }
}
