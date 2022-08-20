/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.deprecated.StringOrRefAdapter;
import org.xmlobjects.gml.model.deprecated.StringOrRef;
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

public class LanguageStringAuxAdapter implements ObjectBuilder<StringOrRef>, ObjectSerializer<StringOrRef> {

    @Override
    public StringOrRef createObject(QName name, Object parent) throws ObjectBuildException {
        return new StringOrRef();
    }

    @Override
    public void initializeObject(StringOrRef object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(StringOrRefAdapter.class).initializeObject(object, name, attributes, reader);
        attributes.getValue(XMLConstants.XML_NS_URI, "lang").ifPresent(object::setLanguage);
    }

    @Override
    public void initializeElement(Element element, StringOrRef object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(StringOrRefAdapter.class).initializeElement(element, object, namespaces, writer);
        element.addAttribute(XMLConstants.XML_NS_URI, "lang", object.getLanguage());
    }
}
