/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2024 Claus Nagel <claus.nagel@gmail.com>
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
    public CoverageMappingRule createObject(QName name, Object parent) throws ObjectBuildException {
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
