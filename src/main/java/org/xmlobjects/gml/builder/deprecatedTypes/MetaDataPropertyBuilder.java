package org.xmlobjects.gml.builder.deprecatedTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.base.AbstractPropertyBuilder;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.deprecatedTypes.AbstractMetaData;
import org.xmlobjects.gml.model.deprecatedTypes.MetaDataProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.BuildResult;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class MetaDataPropertyBuilder extends AbstractPropertyBuilder<MetaDataProperty> {

    @Override
    public MetaDataProperty createObject(QName name) {
        return new MetaDataProperty();
    }

    @Override
    public void initializeObject(MetaDataProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("about").ifPresent(object::setAbout);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void buildChildObject(MetaDataProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuildResult<AbstractMetaData> result = reader.getObject(AbstractMetaData.class);
        if (result.isSetObject())
            object.setObject(result.getObject());
        else if (result.isSetDOMElement())
            object.setGenericElement(GenericElement.of(result.getDOMElement()));
    }

    @Override
    public void writeChildElements(MetaDataProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getObject() != null)
            writer.writeObject(object.getObject(), namespaces);
        else if (object.isSetGenericElement())
            writer.writeDOMElement(object.getGenericElement().getContent());
    }
}
