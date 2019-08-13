package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
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
        @XMLElement(name = "Shell", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Shell", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class ShellAdapter extends AbstractSurfaceAdapter<Shell> {

    @Override
    public Shell createObject(QName name) {
        return new Shell();
    }

    @Override
    public void initializeObject(Shell object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        GMLBuilderHelper.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(Shell object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            if ("surfaceMember".equals(name.getLocalPart()))
                object.getSurfaceMembers().add(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class));
            else
                super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(Shell object, Namespaces namespaces) {
        return namespaces.contains(GMLConstants.GML_3_1_NAMESPACE) ?
                Element.of(GMLConstants.GML_3_1_NAMESPACE, "CompositeSurface") :
                Element.of(GMLConstants.GML_3_2_NAMESPACE, "Shell");
    }

    @Override
    public void initializeElement(Element element, Shell object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);

        if (object.getAggregationType() != AggregationType.SET)
            GMLSerializerHelper.serializeAggregationAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(Shell object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        for (SurfaceProperty property : object.getSurfaceMembers())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "surfaceMember"), property, SurfacePropertyAdapter.class, namespaces);
    }
}
