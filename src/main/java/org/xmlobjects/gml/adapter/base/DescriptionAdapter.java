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

package org.xmlobjects.gml.adapter.base;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.LanguageStringAuxAdapter;
import org.xmlobjects.gml.adapter.deprecated.StringOrRefAdapter;
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

@XMLElements({
        @XMLElement(name = "description", namespaceURI = GMLConstants.GML_3_3_XBT_NAMESPACE),
        @XMLElement(name = "description", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "description", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class DescriptionAdapter implements ObjectBuilder<StringOrRef>, ObjectSerializer<StringOrRef> {

    @Override
    public StringOrRef createObject(QName name) throws ObjectBuildException {
        return new StringOrRef();
    }

    @Override
    public void initializeObject(StringOrRef object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(GMLConstants.GML_3_3_XBT_NAMESPACE.equals(name.getNamespaceURI()) ?
                LanguageStringAuxAdapter.class : StringOrRefAdapter.class)
                .initializeObject(object, name, attributes, reader);
    }
    @Override
    public Element createElement(StringOrRef object, Namespaces namespaces) throws ObjectSerializeException {
        return object.getLanguage() != null && namespaces.contains(GMLConstants.GML_3_3_XBT_NAMESPACE) ?
                Element.of(GMLConstants.GML_3_3_XBT_NAMESPACE, "description") :
                Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "description");
    }

    @Override
    public void initializeElement(Element element, StringOrRef object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(GMLConstants.GML_3_3_XBT_NAMESPACE.equals(element.getName().getNamespaceURI()) ?
                LanguageStringAuxAdapter.class : StringOrRefAdapter.class)
                .initializeElement(element, object, namespaces, writer);
    }
}
