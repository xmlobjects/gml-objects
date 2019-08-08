package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.primitives.PointArrayPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.PointPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
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
        @XMLElement(name = "MultiPoint", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "MultiPoint", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class MultiPointAdapter extends AbstractGeometricAggregateAdapter<MultiPoint> {

    @Override
    public MultiPoint createObject(QName name) {
        return new MultiPoint();
    }

    @Override
    public void buildChildObject(MultiPoint object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "pointMember":
                    object.getPointMember().add(reader.getObjectUsingBuilder(PointPropertyAdapter.class));
                    break;
                case "pointMembers":
                    object.setPointMembers(reader.getObjectUsingBuilder(PointArrayPropertyAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(MultiPoint object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "MultiPoint");
    }

    @Override
    public void writeChildElements(MultiPoint object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        for (PointProperty property : object.getPointMember())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "pointMember"), property, PointPropertyAdapter.class, namespaces);

        if (object.getPointMembers() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "pointMembers"), object.getPointMembers(), PointArrayPropertyAdapter.class, namespaces);
    }
}
