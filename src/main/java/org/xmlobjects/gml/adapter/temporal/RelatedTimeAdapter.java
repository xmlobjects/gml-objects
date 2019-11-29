package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.temporal.RelatedTime;
import org.xmlobjects.gml.model.temporal.RelativePosition;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class RelatedTimeAdapter extends AbstractTimePrimitivePropertyAdapter<RelatedTime<?>> {

    @Override
    public RelatedTime<?> createObject(QName name) throws ObjectBuildException {
        return new RelatedTime<>();
    }

    @Override
    public void initializeObject(RelatedTime<?> object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("relativePosition").ifPresent(v -> object.setRelativePosition(RelativePosition.fromValue(v)));
    }

    @Override
    public void initializeElement(Element element, RelatedTime<?> object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        if (object.getRelativePosition() != null)
            element.addAttribute("relativePosition", object.getRelativePosition().toValue());
    }
}
