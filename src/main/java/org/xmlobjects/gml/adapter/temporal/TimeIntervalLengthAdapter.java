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

package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.temporal.TimeIntervalLength;
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

public class TimeIntervalLengthAdapter implements ObjectBuilder<TimeIntervalLength>, ObjectSerializer<TimeIntervalLength> {

    @Override
    public TimeIntervalLength createObject(QName name) throws ObjectBuildException {
        return new TimeIntervalLength();
    }

    @Override
    public void initializeObject(TimeIntervalLength object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifDouble(object::setValue);
        attributes.getValue("unit").ifPresent(object::setUnit);
        attributes.getValue("radix").ifInteger(object::setRadix);
        attributes.getValue("factor").ifInteger(object::setFactor);
    }

    @Override
    public void initializeElement(Element element, TimeIntervalLength object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addTextContent(TextContent.ofDouble(object.getValue()));
        element.addAttribute("unit", object.getUnit());
        element.addAttribute("radix", TextContent.ofInteger(object.getRadix()));
        element.addAttribute("factor", TextContent.ofInteger(object.getFactor()));
    }
}
