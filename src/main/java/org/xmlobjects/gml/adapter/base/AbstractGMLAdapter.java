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

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.basictypes.CodeWithAuthorityAdapter;
import org.xmlobjects.gml.adapter.deprecated.MetaDataPropertyAdapter;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.deprecated.MetaDataProperty;
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

public abstract class AbstractGMLAdapter<T extends AbstractGML> implements ObjectBuilder<T>, ObjectSerializer<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        attributes.getValue(GMLConstants.GML_3_1_NAMESPACE, "id").ifPresent(object::setId);
        attributes.getValue(GMLConstants.GML_3_2_NAMESPACE, "id").ifPresent(object::setId);
    }

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "description":
                    object.setDescription(reader.getObject(StringOrRef.class));
                    break;
                case "descriptionReference":
                    object.setDescriptionReference(reader.getObjectUsingBuilder(ReferenceAdapter.class));
                    break;
                case "identifier":
                    object.setIdentifier(reader.getObjectUsingBuilder(CodeWithAuthorityAdapter.class));
                    break;
                case "name":
                    object.getNames().add(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "metaDataProperty":
                    object.getMetaDataProperties().add(reader.getObjectUsingBuilder(MetaDataPropertyAdapter.class));
                    break;
            }
        }
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addAttribute(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "id", object.getId());
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        for (MetaDataProperty<?> property : object.getMetaDataProperties())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "metaDataProperty"), property, MetaDataPropertyAdapter.class, namespaces);

        if (object.getDescription() != null)
            writer.writeObject(object.getDescription(), namespaces);

        if (GMLConstants.GML_3_2_NAMESPACE.equals(baseNamespace)) {
            if (object.getDescriptionReference() != null)
                writer.writeElementUsingSerializer(Element.of(baseNamespace, "descriptionReference"), object.getDescriptionReference(), ReferenceAdapter.class, namespaces);

            if (object.getIdentifier() != null)
                writer.writeElementUsingSerializer(Element.of(baseNamespace, "identifier"), object.getIdentifier(), CodeWithAuthorityAdapter.class, namespaces);
        }

        for (Code name : object.getNames())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "name"), name, CodeAdapter.class, namespaces);
    }
}
