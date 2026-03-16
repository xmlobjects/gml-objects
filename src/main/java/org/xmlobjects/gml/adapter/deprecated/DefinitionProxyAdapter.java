/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.deprecated;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.base.ReferenceAdapter;
import org.xmlobjects.gml.adapter.dictionary.DefinitionAdapter;
import org.xmlobjects.gml.model.deprecated.DefinitionProxy;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.composite.CompositeObjectAdapter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "DefinitionProxy", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "DefinitionProxy", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class DefinitionProxyAdapter extends CompositeObjectAdapter<DefinitionProxy> {

    public DefinitionProxyAdapter() {
        super(DefinitionAdapter.class);
    }

    @Override
    public DefinitionProxy createObject(QName name, Object parent) throws ObjectBuildException {
        return new DefinitionProxy();
    }

    @Override
    public void buildChildObject(DefinitionProxy object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            if ("definitionRef".equals(name.getLocalPart())) {
                object.setDefinitionRef(reader.getObjectUsingBuilder(ReferenceAdapter.class));
            } else {
                super.buildChildObject(object, name, attributes, reader);
            }
        }
    }

    @Override
    public Element createElement(DefinitionProxy object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "DefinitionProxy");
    }

    @Override
    public void writeChildElements(DefinitionProxy object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        writer.writeElementUsingSerializer(Element.of(baseNamespace, "definitionRef"), object.getDefinitionRef(), ReferenceAdapter.class, namespaces);
    }
}
