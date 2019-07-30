package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.common.SerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.AbstractRingProperty;
import org.xmlobjects.gml.model.geometry.primitives.PolygonPatch;
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
        @XMLElement(name = "PolygonPatch", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "PolygonPatch", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class PolygonPatchAdapter extends AbstractSurfacePatchAdapter<PolygonPatch> {

    @Override
    public PolygonPatch createObject(QName name) {
        return new PolygonPatch();
    }

    @Override
    public void buildChildObject(PolygonPatch object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "exterior":
                object.setExterior(reader.getObjectUsingBuilder(AbstractRingPropertyAdapter.class));
                break;
            case "interior":
                object.getInterior().add(reader.getObjectUsingBuilder(AbstractRingPropertyAdapter.class));
                break;
        }
    }

    @Override
    public Element createElement(PolygonPatch object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "PolygonPatch");
    }

    @Override
    public void writeChildElements(PolygonPatch object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        if (object.getExterior() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "exterior"), object.getExterior(), AbstractRingPropertyAdapter.class, namespaces);

        for (AbstractRingProperty property : object.getInterior())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "interior"), property, AbstractRingPropertyAdapter.class, namespaces);
    }
}
