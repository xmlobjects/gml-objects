package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.common.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidArrayPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolid;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
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
        @XMLElement(name = "MultiSolid", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "MultiSolid", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class MultiSolidAdapter extends AbstractGeometricAggregateAdapter<MultiSolid> {

    @Override
    public MultiSolid createObject(QName name) {
        return new MultiSolid();
    }

    @Override
    public void buildChildObject(MultiSolid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "solidMember":
                object.getSolidMember().add(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                break;
            case "solidMembers":
                object.setSolidMembers(reader.getObjectUsingBuilder(SolidArrayPropertyAdapter.class));
                break;
        }
    }

    @Override
    public Element createElement(MultiSolid object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "MultiSolid");
    }

    @Override
    public void writeChildElements(MultiSolid object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        for (SolidProperty property : object.getSolidMember())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "solidMember"), property, SolidPropertyAdapter.class, namespaces);

        if (object.getSolidMembers() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "solidMembers"), object.getSolidMembers(), SolidArrayPropertyAdapter.class, namespaces);
    }
}
