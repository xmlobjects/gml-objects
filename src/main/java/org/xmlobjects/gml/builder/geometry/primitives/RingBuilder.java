package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;
import org.xmlobjects.gml.model.geometry.primitives.Ring;
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
        @XMLElement(name = "Ring", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Ring", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class RingBuilder extends AbstractRingBuilder<Ring> {

    @Override
    public Ring createObject(QName name) {
        return new Ring();
    }

    @Override
    public void initializeObject(Ring object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        BuilderHelper.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(Ring object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("curveMember".equals(name.getLocalPart()))
            object.getCurveMembers().add(reader.getObjectUsingBuilder(CurvePropertyBuilder.class));
    }

    @Override
    public Element createElement(Ring object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "Ring");
    }

    @Override
    public void writeChildElements(Ring object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        for (CurveProperty property : object.getCurveMembers())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "curveMember"), property, CurvePropertyBuilder.class, namespaces);
    }
}
