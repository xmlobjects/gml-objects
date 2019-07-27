package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.geometry.GeometryArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiGeometry;
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
        @XMLElement(name = "MultiGeometry", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "MultiGeometry", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class MultiGeometryBuilder extends AbstractGeometricAggregateBuilder<MultiGeometry> {
    private final GeometryPropertyBuilder<GeometryProperty> propertyBuilder = new GeometryPropertyBuilder<>();
    private final GeometryArrayPropertyBuilder<GeometryArrayProperty> arrayPropertyBuilder = new GeometryArrayPropertyBuilder<>();

    @Override
    public MultiGeometry createObject(QName name) {
        return new MultiGeometry();
    }

    @Override
    public void buildChildObject(MultiGeometry object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "geometryMember":
                object.getGeometryMember().add(reader.getObjectUsingBuilder(propertyBuilder));
                break;
            case "geometryMembers":
                object.setGeometryMembers(reader.getObjectUsingBuilder(arrayPropertyBuilder));
                break;
        }
    }

    @Override
    public Element createElement(MultiGeometry object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "MultiGeometry");
    }

    @Override
    public void writeChildElements(MultiGeometry object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        for (GeometryProperty property : object.getGeometryMember())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "geometryMember"), property, propertyBuilder, namespaces);

        if (object.getGeometryMembers() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "geometryMembers"), object.getGeometryMembers(), arrayPropertyBuilder, namespaces);
    }
}
