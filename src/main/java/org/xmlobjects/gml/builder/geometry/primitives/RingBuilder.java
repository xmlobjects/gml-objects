package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.AttributesBuilder;
import org.xmlobjects.gml.model.geometry.primitives.Ring;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
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
        AttributesBuilder.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(Ring object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("curveMember".equals(name.getLocalPart()))
            object.getCurveMembers().add(reader.getObjectUsingBuilder(CurvePropertyBuilder.class));
    }

    @Override
    public Element createElement(Ring object, Namespaces namespaces) {
        return (namespaces.contains(GMLConstants.GML_3_1_NAMESPACE_URI)) ?
                Element.of(GMLConstants.GML_3_1_NAMESPACE_URI, "Ring") :
                Element.of(GMLConstants.GML_3_2_NAMESPACE_URI, "Ring");
    }
}
