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

package org.xmlobjects.gml.adapter.geometry.compact;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.converter.SimpleRectangleConverter;
import org.xmlobjects.gml.model.geometry.compact.SimpleRectangle;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "SimpleRectangle", namespaceURI = GMLConstants.GML_3_3_CE_NAMESPACE),
        @XMLElement(name = "SimpleRectangle", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "SimpleRectangle", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class SimpleRectangleAdapter extends AbstractSimplePolygonAdapter<SimpleRectangle> {

    @Override
    public SimpleRectangle createObject(QName name, Object parent) throws ObjectBuildException {
        return new SimpleRectangle();
    }

    @Override
    public Element createElement(SimpleRectangle object, Namespaces namespaces) throws ObjectSerializeException {
        return namespaces.contains(GMLConstants.GML_3_3_CE_NAMESPACE) ?
                Element.of(GMLConstants.GML_3_3_CE_NAMESPACE, "SimpleRectangle") : null;
    }

    @Override
    public void writeChildElements(SimpleRectangle object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (namespaces.contains(GMLConstants.GML_3_3_CE_NAMESPACE))
            super.writeChildElements(object, namespaces, writer);
        else {
            SimpleRectangleConverter converter = writer.getProperties().get(GMLConstants.SIMPLE_RECTANGLE_CONVERTER, SimpleRectangleConverter.class);
            if (converter != null)
                writer.writeObject(converter.convert(object), namespaces);
        }
    }
}
