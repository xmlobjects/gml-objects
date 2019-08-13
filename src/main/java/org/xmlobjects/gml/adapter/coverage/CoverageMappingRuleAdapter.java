package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.base.ReferenceAdapter;
import org.xmlobjects.gml.model.coverage.CoverageMappingRule;
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

public class CoverageMappingRuleAdapter implements ObjectBuilder<CoverageMappingRule>, ObjectSerializer<CoverageMappingRule> {

    @Override
    public CoverageMappingRule createObject(QName name) {
        return new CoverageMappingRule();
    }

    @Override
    public void buildChildObject(CoverageMappingRule object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "ruleDefinition":
                    reader.getTextContent().ifPresent(object::setRuleDefinition);
                    break;
                case "ruleReference":
                    object.setRuleReference(reader.getObjectUsingBuilder(ReferenceAdapter.class));
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(CoverageMappingRule object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.isSetRuleDefinition())
            writer.writeElement(Element.of(baseNamespace, "ruleDefinition").addTextContent(object.getRuleDefinition()));
        else if (object.isSetRuleReference())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "ruleReference"), object.getRuleReference(), ReferenceAdapter.class, namespaces);
    }
}
