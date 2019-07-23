package org.xmlobjects.gml.builder.deprecatedTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.basicTypes.CodeBuilder;
import org.xmlobjects.gml.builder.basicTypes.NilReasonBuilder;
import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.deprecatedTypes.LocationProperty;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

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
}
