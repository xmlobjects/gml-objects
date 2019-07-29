package org.xmlobjects.gml.builder.deprecated;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.basictypes.CodeBuilder;
import org.xmlobjects.gml.builder.basictypes.NilReasonBuilder;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.deprecated.LocationProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class LocationPropertyBuilder extends GeometryPropertyBuilder<LocationProperty> {

    @Override
    public LocationProperty createObject(QName name) {
        return new LocationProperty();
    }

    @Override
    public void buildChildObject(LocationProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "LocationKeyWord":
                object.setLocationKeyWord(reader.getObjectUsingBuilder(CodeBuilder.class));
                break;
            case "LocationString":
                object.setLocationString(reader.getObjectUsingBuilder(StringOrRefBuilder.class));
                break;
            case "Null":
                object.setNull(reader.getObjectUsingBuilder(NilReasonBuilder.class));
                break;
            default:
                super.buildChildObject(object, name, attributes, reader);
                break;
        }
    }

    @Override
    public void writeChildElements(LocationProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetObject())
            super.writeChildElements(object, namespaces, writer);
        else if (object.isSetLocationKeyWord())
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "LocationKeyWord"), object.getLocationKeyWord(), CodeBuilder.class, namespaces);
        else if (object.isSetLocationString())
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "LocationString"), object.getLocationString(), StringOrRefBuilder.class, namespaces);
        else if (object.isSetNull())
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "Null"), object.getNull(), NilReasonBuilder.class, namespaces);
    }
}
