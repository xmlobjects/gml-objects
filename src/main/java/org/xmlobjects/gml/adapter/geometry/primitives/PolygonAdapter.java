package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.common.SerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.AbstractRingProperty;
import org.xmlobjects.gml.model.geometry.primitives.Polygon;
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
        @XMLElement(name = "Polygon", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Polygon", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class PolygonAdapter extends AbstractSurfaceAdapter<Polygon> {

    @Override
    public Polygon createObject(QName name) {
        return new Polygon();
    }

    @Override
    public void buildChildObject(Polygon object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "exterior":
            case "outerBoundaryIs":
                object.setExterior(reader.getObjectUsingBuilder(AbstractRingPropertyAdapter.class));
                break;
            case "interior":
            case "innerBoundaryIs":
                object.getInterior().add(reader.getObjectUsingBuilder(AbstractRingPropertyAdapter.class));
                break;
            default:
                super.buildChildObject(object, name, attributes, reader);
                break;
        }
    }

    @Override
    public Element createElement(Polygon object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "Polygon");
    }

    @Override
    public void writeChildElements(Polygon object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        if (object.getExterior() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "exterior"), object.getExterior(), AbstractRingPropertyAdapter.class, namespaces);

        for (AbstractRingProperty property : object.getInterior())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "interior"), property, AbstractRingPropertyAdapter.class, namespaces);
    }
}
