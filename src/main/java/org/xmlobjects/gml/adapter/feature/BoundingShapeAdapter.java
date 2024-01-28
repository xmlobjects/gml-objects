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

package org.xmlobjects.gml.adapter.feature;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.NilReasonAdapter;
import org.xmlobjects.gml.adapter.geometry.EnvelopeAdapter;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.feature.BoundingShape;
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

public class BoundingShapeAdapter implements ObjectBuilder<BoundingShape>, ObjectSerializer<BoundingShape> {

    @Override
    public BoundingShape createObject(QName name, Object parent) throws ObjectBuildException {
        return new BoundingShape();
    }

    @Override
    public void initializeObject(BoundingShape object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        attributes.getValue("nilReason").ifPresent(v -> object.setNilReason(new NilReason(v)));
    }

    @Override
    public void buildChildObject(BoundingShape object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "Envelope":
                    object.setEnvelope(reader.getObjectUsingBuilder(EnvelopeAdapter.class));
                    break;
                case "Null":
                    if (!object.isSetNilReason() || object.getNilReason().getValue() == null)
                        object.setNilReason(reader.getObjectUsingBuilder(NilReasonAdapter.class));
                    break;
            }
        }
    }

    @Override
    public void initializeElement(Element element, BoundingShape object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetNilReason() && GMLConstants.GML_3_2_NAMESPACE.equals(GMLSerializerHelper.getGMLBaseNamespace(namespaces))) {
            element.addAttribute("nilReason", object.getNilReason().getValue());
            element.addAttribute(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "nil", "true");
        }
    }

    @Override
    public void writeChildElements(BoundingShape object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.isSetEnvelope())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "Envelope"), object.getEnvelope(), EnvelopeAdapter.class, namespaces);

        if (object.isSetNilReason() && GMLConstants.GML_3_1_NAMESPACE.equals(baseNamespace))
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "Null"), object.getNilReason(), NilReasonAdapter.class, namespaces);
    }
}
