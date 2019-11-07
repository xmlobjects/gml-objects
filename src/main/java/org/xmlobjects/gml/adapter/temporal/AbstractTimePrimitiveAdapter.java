package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.temporal.AbstractTimePrimitive;
import org.xmlobjects.gml.model.temporal.RelatedTime;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractTimePrimitiveAdapter<T extends AbstractTimePrimitive> extends AbstractTimeObjectAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            if ("relatedTime".equals(name.getLocalPart()))
                object.getRelatedTimes().add(reader.getObjectUsingBuilder(RelatedTimeAdapter.class));
            else
                super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        for (RelatedTime property : object.getRelatedTimes())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "relatedTime"), property, RelatedTimeAdapter.class, namespaces);
    }
}
