package org.xmlobjects.gml.adapter.feature;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractGMLAdapter;
import org.xmlobjects.gml.adapter.common.SerializerHelper;
import org.xmlobjects.gml.adapter.deprecated.LocationPropertyAdapter;
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

public abstract class AbstractFeatureAdapter<T extends AbstractFeature> extends AbstractGMLAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "boundedBy":
                object.setBoundedBy(reader.getObjectUsingBuilder(BoundingShapeAdapter.class));
                break;
            case "location":
                object.setLocation(reader.getObjectUsingBuilder(LocationPropertyAdapter.class));
                break;
            default:
                super.buildChildObject(object, name, attributes, reader);
                break;
        }
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        if (object.getBoundedBy() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "boundedBy"), object.getBoundedBy(), BoundingShapeAdapter.class, namespaces);

        if (object.getLocation() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "location"), object.getLocation(), LocationPropertyAdapter.class, namespaces);
    }
}
