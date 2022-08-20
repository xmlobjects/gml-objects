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

package org.xmlobjects.gml.adapter.dictionary;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractGMLAdapter;
import org.xmlobjects.gml.adapter.basictypes.CodeWithAuthorityAdapter;
import org.xmlobjects.gml.model.dictionary.DefinitionBase;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class DefinitionBaseAdapter<T extends DefinitionBase> extends AbstractGMLAdapter<T> {
    private final CopyBuilder copyBuilder = new CopyBuilder();

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLConstants.GML_3_1_NAMESPACE.equals(name.getNamespaceURI())
                && "name".equals(name.getLocalPart())
                && object.getIdentifier() == null) {
            object.setIdentifier(reader.getObjectUsingBuilder(CodeWithAuthorityAdapter.class));
        } else {
            super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getIdentifier() != null && namespaces.contains(GMLConstants.GML_3_1_NAMESPACE)) {
            object = copyBuilder.shallowCopy(object);
            if (object.getIdentifier() != null) {
                object.setNames(Stream.of(Collections.singletonList(object.getIdentifier()), object.getNames())
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()));
                object.setIdentifier(null);
            }
        }

        super.writeChildElements(object, namespaces, writer);
    }
}
