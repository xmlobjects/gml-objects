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

package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.BooleanOrNilReason;
import org.xmlobjects.gml.model.basictypes.BooleanOrNilReasonList;
import org.xmlobjects.gml.model.basictypes.NilReason;
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
import java.util.Objects;
import java.util.stream.Collectors;

public class BooleanOrNilReasonListAdapter implements ObjectBuilder<BooleanOrNilReasonList>, ObjectSerializer<BooleanOrNilReasonList> {

    @Override
    public BooleanOrNilReasonList createObject(QName name, Object parent) throws ObjectBuildException {
        return new BooleanOrNilReasonList();
    }

    @Override
    public void initializeObject(BooleanOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        TextContent content = reader.getTextContent();
        for (String item : content.getAsList()) {
            TextContent value = TextContent.of(item);
            if (value.isBoolean())
                object.getValue().add(new BooleanOrNilReason(value.getAsBoolean()));
            else
                object.getValue().add(new BooleanOrNilReason(new NilReason(item)));
        }
    }

    @Override
    public void initializeElement(Element element, BooleanOrNilReasonList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetValue()) {
            element.addTextContent(TextContent.ofList(object.getValue().stream()
                    .filter(Objects::nonNull)
                    .map(v -> {
                        if (v.isSetValue())
                            return v.getValue().toString();
                        else if (v.isSetNilReason())
                            return v.getNilReason().getValue();
                        else
                            return null;
                    }).collect(Collectors.toList())));
        }
    }
}
