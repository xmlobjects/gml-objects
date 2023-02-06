/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2023 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.gml.adapter.basictypes.MeasureOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.QuantityExtent;
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
        @XMLElement(name = "QuantityExtent", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "QuantityExtent", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class QuantityExtentAdapter implements ObjectBuilder<QuantityExtent>, ObjectSerializer<QuantityExtent> {

    @Override
    public QuantityExtent createObject(QName name, Object parent) throws ObjectBuildException {
        return new QuantityExtent();
    }

    @Override
    public void initializeObject(QuantityExtent object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(MeasureOrNilReasonListAdapter.class).initializeObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(QuantityExtent object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "QuantityExtent");
    }

    @Override
    public void initializeElement(Element element, QuantityExtent object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(MeasureOrNilReasonListAdapter.class).initializeElement(element, object, namespaces, writer);
    }
}
