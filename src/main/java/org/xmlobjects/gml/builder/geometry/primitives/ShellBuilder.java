package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.geometry.primitives.Shell;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Shell", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Shell", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class ShellBuilder extends AbstractSurfaceBuilder<Shell> {

    @Override
    public Shell createObject(QName name) {
        return new Shell();
    }

    @Override
    public void initializeObject(Shell object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        BuilderHelper.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(Shell object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("surfaceMember".equals(name.getLocalPart()))
            object.getSurfaceMembers().add(reader.getObjectUsingBuilder(SurfacePropertyBuilder.class));
    }

    @Override
    public Element createElement(Shell object, Namespaces namespaces) {
        return namespaces.contains(GMLConstants.GML_3_1_NAMESPACE_URI) ?
                Element.of(GMLConstants.GML_3_1_NAMESPACE_URI, "CompositeSurface") :
                Element.of(GMLConstants.GML_3_2_NAMESPACE_URI, "Shell");
    }

    @Override
    public void initializeElement(Element element, Shell object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);

        if (object.getAggregationType() != AggregationType.SET)
            SerializerHelper.serializeAggregationAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(Shell object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        for (SurfaceProperty property : object.getSurfaceMembers())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "surfaceMember"), property, SurfacePropertyBuilder.class, namespaces);
    }
}
