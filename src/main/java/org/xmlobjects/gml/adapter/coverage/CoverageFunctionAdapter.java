package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.deprecated.StringOrRefAdapter;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.coverage.CoverageFunction;
import org.xmlobjects.gml.model.coverage.CoverageMappingRule;
import org.xmlobjects.gml.model.deprecated.StringOrRef;
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

public class CoverageFunctionAdapter implements ObjectBuilder<CoverageFunction>, ObjectSerializer<CoverageFunction> {

    @Override
    public CoverageFunction createObject(QName name) {
        return new CoverageFunction();
    }

    @Override
    public void buildChildObject(CoverageFunction object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "MappingRule":
                    StringOrRef value = reader.getObjectUsingBuilder(StringOrRefAdapter.class);
                    object.setMappingRule(new CoverageMappingRule(value.getValue()));
                    if (value.getHref() != null)
                        object.getMappingRule().setRuleReference(new Reference(value));
                    break;
                case "CoverageMappingRule":
                    object.setMappingRule(reader.getObjectUsingBuilder(CoverageMappingRuleAdapter.class));
                    break;
                case "GridFunction":
                    object.setGridFunction(reader.getObjectUsingBuilder(GridFunctionAdapter.class));
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(CoverageFunction object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.isSetMappingRule()) {
            if (GMLConstants.GML_3_2_NAMESPACE.equals(baseNamespace))
                writer.writeElementUsingSerializer(Element.of(baseNamespace, "CoverageMappingRule"), object.getMappingRule(), CoverageMappingRuleAdapter.class, namespaces);
            else {
                StringOrRef value = new StringOrRef(object.getMappingRule().getRuleDefinition());
                if (object.getMappingRule().isSetRuleReference())
                    value.setReference(object.getMappingRule().getRuleReference());

                writer.writeElementUsingSerializer(Element.of(baseNamespace, "MappingRule"), value, StringOrRefAdapter.class, namespaces);
            }
        } else if (object.isSetGridFunction())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "GridFunction"), object.getGridFunction(), GridFunctionAdapter.class, namespaces);
    }
}
