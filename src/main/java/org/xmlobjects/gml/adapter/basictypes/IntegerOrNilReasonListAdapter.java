/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2025 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.gml.model.basictypes.IntegerOrNilReason;
import org.xmlobjects.gml.model.basictypes.IntegerOrNilReasonList;
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

public class IntegerOrNilReasonListAdapter implements ObjectBuilder<IntegerOrNilReasonList>, ObjectSerializer<IntegerOrNilReasonList> {

    @Override
    public IntegerOrNilReasonList createObject(QName name, Object parent) throws ObjectBuildException {
        return new IntegerOrNilReasonList();
    }

    @Override
    public void initializeObject(IntegerOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        TextContent content = reader.getTextContent();
        for (String item : content.getAsList()) {
            try {
                object.getValue().add(new IntegerOrNilReason(Integer.parseInt(item)));
            } catch (Throwable e) {
                object.getValue().add(new IntegerOrNilReason(new NilReason(item)));
            }
        }
    }

    @Override
    public void initializeElement(Element element, IntegerOrNilReasonList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
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
