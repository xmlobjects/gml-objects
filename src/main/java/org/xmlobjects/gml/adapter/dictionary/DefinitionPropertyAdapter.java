/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.dictionary;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.deprecated.DefinitionProxy;
import org.xmlobjects.gml.model.dictionary.DefinitionProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class DefinitionPropertyAdapter extends AbstractPropertyAdapter<DefinitionProperty> {

    @Override
    public DefinitionProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new DefinitionProperty();
    }

    @Override
    public void initializeElement(Element element, DefinitionProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (!(object.getObject() instanceof DefinitionProxy)) {
            super.initializeElement(element, object, namespaces, writer);
        }
    }
}
