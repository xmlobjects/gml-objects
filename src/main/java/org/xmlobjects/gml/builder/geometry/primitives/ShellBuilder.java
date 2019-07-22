package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.AttributesBuilder;
import org.xmlobjects.gml.model.geometry.primitives.Shell;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElement(name = "Shell", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI)
public class ShellBuilder extends AbstractSurfaceBuilder<Shell> {

    @Override
    public Shell createObject(QName name) {
        return new Shell();
    }

    @Override
    public void initializeObject(Shell object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        AttributesBuilder.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(Shell object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("surfaceMember".equals(name.getLocalPart()))
            object.getSurfaceMembers().add(reader.getObjectUsingBuilder(SurfacePropertyBuilder.class));
    }
}
