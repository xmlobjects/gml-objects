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
import org.xmlobjects.gml.model.deprecated.DefinitionProxy;
import org.xmlobjects.gml.model.dictionary.DefinitionProperty;
import org.xmlobjects.gml.model.dictionary.Dictionary;
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
        @XMLElement(name = "Dictionary", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Dictionary", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class DictionaryAdapter extends CompositeObjectAdapter<Dictionary> {

    public DictionaryAdapter() {
        super(DefinitionAdapter.class);
    }

    @Override
    public Dictionary createObject(QName name, Object parent) throws ObjectBuildException {
        return new Dictionary();
    }

    @Override
    public void initializeObject(Dictionary object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        GMLBuilderHelper.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(Dictionary object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "dictionaryEntry":
                case "indirectEntry":
                    DefinitionProperty property = reader.getObjectUsingBuilder(DefinitionPropertyAdapter.class);
                    if (property.getObject() instanceof DefinitionProxy) {
                        property.setReference(null);
                        property.setOwns(null);
                    }
                    object.getDefinitions().add(property);
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(Dictionary object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "Dictionary");
    }

    @Override
    public void initializeElement(Element element, Dictionary object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        GMLSerializerHelper.serializeAggregationAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(Dictionary object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.isSetDefinitions()) {
            for (DefinitionProperty property : object.getDefinitions()) {
                if (property.getObject() instanceof DefinitionProxy) {
                    writer.writeElementUsingSerializer(Element.of(baseNamespace, "indirectEntry"), property, DefinitionPropertyAdapter.class, namespaces);
                } else {
                    writer.writeElementUsingSerializer(Element.of(baseNamespace, "dictionaryEntry"), property, DefinitionPropertyAdapter.class, namespaces);
                }
            }
        }
    }
}
