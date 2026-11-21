/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.dictionary;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.copy.Copier;
import org.xmlobjects.copy.CopierBuilder;
import org.xmlobjects.gml.adapter.base.AbstractGMLAdapter;
import org.xmlobjects.gml.adapter.basictypes.CodeWithAuthorityAdapter;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.dictionary.DefinitionBase;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public abstract class DefinitionBaseAdapter<T extends DefinitionBase> extends AbstractGMLAdapter<T> {
    private final Copier copier = CopierBuilder.newCopier();

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
            // GML 3.1 has no identifier, so it is written as first name. The names are copied, since adding
            // them to the list of the temporary object would otherwise change their parent in the original
            List<Code> names = new ArrayList<>(object.getNames().size() + 1);
            names.add(copier.shallowCopy(object.getIdentifier()));
            for (Code name : object.getNames()) {
                names.add(copier.shallowCopy(name));
            }

            object = copier.shallowCopy(object);
            object.setNames(names);
            object.setIdentifier(null);
        }

        super.writeChildElements(object, namespaces, writer);
    }
}
