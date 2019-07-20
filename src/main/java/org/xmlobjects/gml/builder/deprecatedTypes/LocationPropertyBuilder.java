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
    public void buildNestedObject(LocationProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if ("LocationKeyWord".equals(name.getLocalPart()))
            object.setLocationKeyWord(reader.getObjectUsingBuilder(CodeBuilder.class));
        else if ("LocationString".equals(name.getLocalPart()))
            object.setLocationString(reader.getObjectUsingBuilder(StringOrRefBuilder.class));
        else if ("Null".equals(name.getLocalPart()))
            object.setNull(reader.getObjectUsingBuilder(NilReasonBuilder.class));
        else
            super.buildNestedObject(object, name, attributes, reader);
    }
}
