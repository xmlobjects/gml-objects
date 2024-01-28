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

package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.NilReasonAdapter;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.valueobjects.AbstractValue;
import org.xmlobjects.gml.model.valueobjects.Value;
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

public class ValueAdapter implements ObjectBuilder<Value>, ObjectSerializer<Value> {

    @Override
    public Value createObject(QName name, Object parent) throws ObjectBuildException {
        return new Value();
    }

    @Override
    public void buildChildObject(Value object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        GMLObject child = reader.getObject(GMLObject.class);
        if (child instanceof AbstractValue value)
            object.setValue(value);
        else if (child instanceof AbstractGeometry geometry)
            object.setGeometry(geometry);
        else if (child instanceof NilReason nilReason)
            object.setNull(nilReason);
        else
            object.setGenericElement(GenericElement.of(reader.getDOMElement()));
    }

    @Override
    public void writeChildElements(Value object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetValue())
            writer.writeObject(object.getValue(), namespaces);
        else if (object.isSetGeometry())
            writer.writeObject(object.getGeometry(), namespaces);
        else if (object.isSetNull())
            writer.writeElementUsingSerializer(Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "Null"), object.getNull(), NilReasonAdapter.class, namespaces);
        else if (object.isSetGenericElement())
            writer.writeDOMElement(object.getGenericElement().getContent());
    }
}
