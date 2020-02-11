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

package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.valueobjects.Count;
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

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Count", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Count", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class CountAdapter implements ObjectBuilder<Count>, ObjectSerializer<Count> {

    @Override
    public Count createObject(QName name) throws ObjectBuildException {
        return new Count();
    }

    @Override
    public void initializeObject(Count object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifInteger(object::setValue);
        if (!object.isSetValue())
            attributes.getValue("nilReason").ifPresent(v -> object.setNilReason(new NilReason(v)));
    }

    @Override
    public Element createElement(Count object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "Count");
    }

    @Override
    public void initializeElement(Element element, Count object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetValue())
            element.addTextContent(TextContent.ofInteger(object.getValue()));
        else if (object.isSetNilReason() && GMLConstants.GML_3_2_NAMESPACE.equals(GMLSerializerHelper.getGMLBaseNamespace(namespaces))) {
            element.addAttribute("nilReason", object.getNilReason().getValue());
            element.addAttribute(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "nil", "true");
        }
    }
}
