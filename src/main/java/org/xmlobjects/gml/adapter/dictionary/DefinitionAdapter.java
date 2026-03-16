/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.dictionary;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.dictionary.Definition;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Definition", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Definition", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class DefinitionAdapter extends DefinitionBaseAdapter<Definition> {

    @Override
    public Definition createObject(QName name, Object parent) throws ObjectBuildException {
        return new Definition();
    }

    @Override
    public void buildChildObject(Definition object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            if ("remarks".equals(name.getLocalPart())) {
                reader.getTextContent().ifPresent(object::setRemarks);
            } else {
                super.buildChildObject(object, name, attributes, reader);
            }
        }
    }

    @Override
    public Element createElement(Definition object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "Definition");
    }

    @Override
    public void writeChildElements(Definition object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getRemarks() != null && GMLConstants.GML_3_2_NAMESPACE.equals(baseNamespace)) {
            writer.writeElement(Element.of(baseNamespace, "remarks").addTextContent(object.getRemarks()));
        }
    }
}
