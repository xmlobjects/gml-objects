/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.DoubleOrNilReason;
import org.xmlobjects.gml.model.basictypes.DoubleOrNilReasonList;
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

public class DoubleOrNilReasonListAdapter implements ObjectBuilder<DoubleOrNilReasonList>, ObjectSerializer<DoubleOrNilReasonList> {

    @Override
    public DoubleOrNilReasonList createObject(QName name, Object parent) throws ObjectBuildException {
        return new DoubleOrNilReasonList();
    }

    @Override
    public void initializeObject(DoubleOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifList(values -> {
            for (String item : values) {
                try {
                    object.getValue().add(new DoubleOrNilReason(Double.parseDouble(item)));
                } catch (Throwable e) {
                    object.getValue().add(new DoubleOrNilReason(new NilReason(item)));
                }
            }
        });
    }

    @Override
    public void initializeElement(Element element, DoubleOrNilReasonList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
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
