package org.xmlobjects.gml.adapter.geometry.grids;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.geometry.grids.GridEnvelope;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class GridEnvelopeAdapter implements ObjectBuilder<GridEnvelope>, ObjectSerializer<GridEnvelope> {

    @Override
    public GridEnvelope createObject(QName name) {
        return new GridEnvelope();
    }

    @Override
    public void buildChildObject(GridEnvelope object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "low":
                    reader.getTextContent().ifIntegerList(object::setLow);
                    break;
                case "high":
                    reader.getTextContent().ifIntegerList(object::setHigh);
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(GridEnvelope object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        if (!object.getLow().isEmpty())
            writer.writeElement(Element.of(baseNamespace, "low").addTextContent(TextContent.ofIntegerList(object.getLow())));

        if (!object.getHigh().isEmpty())
            writer.writeElement(Element.of(baseNamespace, "high").addTextContent(TextContent.ofIntegerList(object.getHigh())));
    }
}
