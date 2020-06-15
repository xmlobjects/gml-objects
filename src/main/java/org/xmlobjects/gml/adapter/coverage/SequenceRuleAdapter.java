/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
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
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.coverage.IncrementOrder;
import org.xmlobjects.gml.model.coverage.SequenceRule;
import org.xmlobjects.gml.model.coverage.SequenceRuleEnumeration;
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
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class SequenceRuleAdapter implements ObjectBuilder<SequenceRule>, ObjectSerializer<SequenceRule> {

    @Override
    public SequenceRule createObject(QName name, Object parent) throws ObjectBuildException {
        return new SequenceRule();
    }

    @Override
    public void initializeObject(SequenceRule object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifPresent(v -> object.setValue(SequenceRuleEnumeration.fromValue(v)));
        attributes.getValue("order").ifPresent(v -> object.setAxisOrders(IncrementOrder.fromValue(v)));
        attributes.getValue("axisOrder").ifList(object::setAxisOrders);
    }

    @Override
    public void initializeElement(Element element, SequenceRule object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addTextContent(object.getValue().toValue());

        if (!object.getAxisOrders().isEmpty()) {
            if (GMLConstants.GML_3_2_NAMESPACE.equals(GMLSerializerHelper.getGMLBaseNamespace(namespaces)))
                element.addAttribute("axisOrder", TextContent.ofList(object.getAxisOrders()));
            else {
                IncrementOrder order = IncrementOrder.fromAxisOrders(object.getAxisOrders());
                if (order != null)
                    element.addAttribute("order", order.toValue());
            }
        }
    }
}
