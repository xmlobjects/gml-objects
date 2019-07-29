package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.geometry.primitives.PointArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.PointPropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
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
        @XMLElement(name = "MultiPoint", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "MultiPoint", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class MultiPointBuilder extends AbstractGeometricAggregateBuilder<MultiPoint> {

    @Override
    public MultiPoint createObject(QName name) {
        return new MultiPoint();
    }

    @Override
    public void buildChildObject(MultiPoint object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "pointMember":
                object.getPointMember().add(reader.getObjectUsingBuilder(PointPropertyBuilder.class));
                break;
            case "pointMembers":
                object.setPointMembers(reader.getObjectUsingBuilder(PointArrayPropertyBuilder.class));
                break;
        }
    }

    @Override
    public Element createElement(MultiPoint object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "MultiPoint");
    }

    @Override
    public void writeChildElements(MultiPoint object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        for (PointProperty property : object.getPointMember())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "pointMember"), property, PointPropertyBuilder.class, namespaces);

        if (object.getPointMembers() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "pointMembers"), object.getPointMembers(), PointArrayPropertyBuilder.class, namespaces);
    }
}
