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

package org.xmlobjects.gml.adapter.base;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.base.AbstractMetadataProperty;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.model.Child;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.*;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@SuppressWarnings("rawtypes")
public abstract class AbstractMetadataPropertyAdapter<T extends AbstractMetadataProperty> implements ObjectBuilder<T>, ObjectSerializer<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        GMLBuilderHelper.buildOwnershipAttributes(object, attributes);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuildResult<Child> result = reader.getObjectOrDOMElement(object.getTargetType());
        if (result.isSetObject())
            object.setObject(result.getObject());
        else if (result.isSetDOMElement())
            object.setGenericElement(GenericElement.of(result.getDOMElement()));
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        GMLSerializerHelper.serializeOwnershipAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetObject())
            writer.writeObject(object.getObject(), namespaces);
        else if (object.isSetGenericElement())
            writer.writeDOMElement(object.getGenericElement().getContent());
    }
}
