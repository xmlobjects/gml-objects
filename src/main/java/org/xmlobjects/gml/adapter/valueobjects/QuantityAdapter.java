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
import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.valueobjects.Quantity;
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

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Quantity", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Quantity", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class QuantityAdapter implements ObjectBuilder<Quantity>, ObjectSerializer<Quantity> {
    private final MeasureAdapter adapter = new MeasureAdapter();

    @Override
    public Quantity createObject(QName name) throws ObjectBuildException {
        return new Quantity();
    }

    @Override
    public void initializeObject(Quantity object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        adapter.initializeObject(object, name, attributes, reader);
        if (!object.isSetValue())
            attributes.getValue("nilReason").ifPresent(v -> object.setNilReason(new NilReason(v)));
    }

    @Override
    public Element createElement(Quantity object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "Quantity");
    }

    @Override
    public void initializeElement(Element element, Quantity object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetValue())
            adapter.initializeElement(element, object, namespaces, writer);
        else if (object.isSetNilReason() && GMLConstants.GML_3_2_NAMESPACE.equals(GMLSerializerHelper.getGMLBaseNamespace(namespaces))) {
            element.addAttribute("nilReason", object.getNilReason().getValue());
            element.addAttribute(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "nil", "true");
        }
    }
}
