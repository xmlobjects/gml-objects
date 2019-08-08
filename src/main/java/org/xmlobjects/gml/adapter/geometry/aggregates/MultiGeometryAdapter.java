package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.GeometryArrayPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiGeometry;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "MultiGeometry", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "MultiGeometry", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class MultiGeometryAdapter extends AbstractGeometricAggregateAdapter<MultiGeometry> {
    private final GeometryPropertyAdapter<GeometryProperty> propertyAdapter = new GeometryPropertyAdapter<>();
    private final GeometryArrayPropertyAdapter<GeometryArrayProperty> arrayPropertyAdapter = new GeometryArrayPropertyAdapter<>();

    @Override
    public MultiGeometry createObject(QName name, Properties properties) {
        return new MultiGeometry();
    }

    @Override
    public void buildChildObject(MultiGeometry object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "geometryMember":
                    object.getGeometryMember().add(reader.getObjectUsingBuilder(propertyAdapter));
                    break;
                case "geometryMembers":
                    object.setGeometryMembers(reader.getObjectUsingBuilder(arrayPropertyAdapter));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(MultiGeometry object, Namespaces namespaces, Properties properties) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "MultiGeometry");
    }

    @Override
    public void writeChildElements(MultiGeometry object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        for (GeometryProperty property : object.getGeometryMember())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "geometryMember"), property, propertyAdapter, namespaces);

        if (object.getGeometryMembers() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "geometryMembers"), object.getGeometryMembers(), arrayPropertyAdapter, namespaces);
    }
}
