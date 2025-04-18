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

package org.xmlobjects.gml.adapter.deprecated;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.deprecated.AbstractMetaData;
import org.xmlobjects.gml.model.deprecated.MetaDataProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.*;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class MetaDataPropertyAdapter extends AbstractPropertyAdapter<MetaDataProperty<?>> {

    @Override
    public MetaDataProperty<?> createObject(QName name, Object parent) throws ObjectBuildException {
        return new MetaDataProperty<>();
    }

    @Override
    public void initializeObject(MetaDataProperty<?> object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("about").ifPresent(object::setAbout);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void buildChildObject(MetaDataProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuildResult<AbstractMetaData> result = reader.getObjectOrDOMElement(object.getTargetType());
        if (result.isSetObject())
            object.setInlineObject(result.getObject());
        else if (result.isSetDOMElement())
            object.setGenericElement(GenericElement.of(result.getDOMElement()));
    }

    @Override
    public void writeChildElements(MetaDataProperty<?> object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetInlineObject())
            writer.writeObject(object.getObject(), namespaces);
        else if (object.isSetGenericElement())
            writer.writeDOMElement(object.getGenericElement().getContent());
    }
}
