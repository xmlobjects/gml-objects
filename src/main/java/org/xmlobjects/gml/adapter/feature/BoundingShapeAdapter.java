package org.xmlobjects.gml.adapter.feature;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.NilReasonAdapter;
import org.xmlobjects.gml.adapter.geometry.EnvelopeAdapter;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.feature.BoundingShape;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class BoundingShapeAdapter implements ObjectBuilder<BoundingShape>, ObjectSerializer<BoundingShape> {

    @Override
    public BoundingShape createObject(QName name) {
        return new BoundingShape();
    }

    @Override
    public void initializeObject(BoundingShape object, QName name, Attributes attributes, XMLReader reader) {
        attributes.getValue("nilReason").ifPresent(v -> object.setNilReason(new NilReason(v)));
    }

    @Override
    public void buildChildObject(BoundingShape object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "Envelope":
                    object.setEnvelope(reader.getObjectUsingBuilder(EnvelopeAdapter.class));
                    break;
                case "Null":
                    if (object.getNilReason() == null || object.getNilReason().getValue() == null)
                        object.setNilReason(reader.getObjectUsingBuilder(NilReasonAdapter.class));
                    break;
            }
        }
    }

    @Override
    public void initializeElement(Element element, BoundingShape object, Namespaces namespaces, XMLWriter writer) {
        if (object.getNilReason() != null && GMLConstants.GML_3_2_NAMESPACE.equals(SerializerHelper.getGMLBaseNamespace(namespaces)))
            element.addAttribute("nilReason", object.getNilReason().getValue());
    }

    @Override
    public void writeChildElements(BoundingShape object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getEnvelope() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "Envelope"), object.getEnvelope(), EnvelopeAdapter.class, namespaces);

        if (object.getNilReason() != null && GMLConstants.GML_3_1_NAMESPACE.equals(baseNamespace))
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "Null"), object.getNilReason(), NilReasonAdapter.class, namespaces);
    }
}
