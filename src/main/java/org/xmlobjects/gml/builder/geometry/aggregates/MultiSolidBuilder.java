package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.geometry.primitives.SolidArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.SolidPropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolid;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "MultiSolid", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "MultiSolid", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class MultiSolidBuilder extends AbstractGeometricAggregateBuilder<MultiSolid> {

    @Override
    public MultiSolid createObject(QName name) {
        return new MultiSolid();
    }

    @Override
    public void buildChildObject(MultiSolid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "solidMember":
                object.getSolidMember().add(reader.getObjectUsingBuilder(SolidPropertyBuilder.class));
                break;
            case "solidMembers":
                object.setSolidMembers(reader.getObjectUsingBuilder(SolidArrayPropertyBuilder.class));
                break;
        }
    }

    @Override
    public Element createElement(MultiSolid object, Namespaces namespaces) {
        return namespaces.contains(GMLConstants.GML_3_1_NAMESPACE_URI) ?
                Element.of(GMLConstants.GML_3_1_NAMESPACE_URI, "MultiSolid") :
                Element.of(GMLConstants.GML_3_2_NAMESPACE_URI, "MultiSolid");
    }
}
