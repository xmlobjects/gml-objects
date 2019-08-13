package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.coverage.GridFunction;
import org.xmlobjects.gml.model.coverage.SequenceRuleEnumeration;
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

public class GridFunctionAdapter implements ObjectBuilder<GridFunction>, ObjectSerializer<GridFunction> {

    @Override
    public GridFunction createObject(QName name) {
        return new GridFunction();
    }

    @Override
    public void buildChildObject(GridFunction object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "sequenceRule":
                    object.setSequenceRule(reader.getObjectUsingBuilder(SequenceRuleAdapter.class));
                    break;
                case "startPoint":
                    reader.getTextContent().ifIntegerList(object::setStartPoints);
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(GridFunction object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getSequenceRule() != null
                && (object.getSequenceRule().getValue() != SequenceRuleEnumeration.LINEAR
                || !object.getSequenceRule().getAxisOrders().isEmpty()))
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "sequenceRule"), object.getSequenceRule(), SequenceRuleAdapter.class, namespaces);

        if (object.getStartPoints() != null)
            writer.writeElement(Element.of(baseNamespace, "startPoint").addTextContent(TextContent.ofIntegerList(object.getStartPoints())));
    }
}
