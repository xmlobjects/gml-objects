/*
 * gml-objects - A Java XML binding for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2020 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
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
    public CoverageFunction createObject(QName name) throws ObjectBuildException {
        return new CoverageFunction();
    }

    @Override
    public void buildChildObject(CoverageFunction object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
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
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

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
