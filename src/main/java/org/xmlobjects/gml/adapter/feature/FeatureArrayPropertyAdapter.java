package org.xmlobjects.gml.adapter.feature;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.ArrayPropertyAdapter;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.feature.FeatureArrayProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.BuildResult;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class FeatureArrayPropertyAdapter<T extends FeatureArrayProperty> extends ArrayPropertyAdapter<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) throws ObjectBuildException {
        return (T) new FeatureArrayProperty<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuildResult<GMLObject> result = reader.getObjectOrDOMElement(object.getTargetType());
        if (result.isSetObject())
            object.getObjects().add(result.getObject());
        else if (result.isSetDOMElement())
            object.getGenericElements().add(GenericElement.of(result.getDOMElement()));
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (Object child : object.getGenericElements())
            writer.writeDOMElement(((GenericElement) child).getContent());
    }
}
