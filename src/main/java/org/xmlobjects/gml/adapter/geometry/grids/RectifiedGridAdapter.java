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

package org.xmlobjects.gml.adapter.geometry.grids;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.geometry.VectorAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.PointPropertyAdapter;
import org.xmlobjects.gml.model.geometry.Vector;
import org.xmlobjects.gml.model.geometry.grids.RectifiedGrid;
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
        @XMLElement(name = "RectifiedGrid", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "RectifiedGrid", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class RectifiedGridAdapter extends AbstractGridAdapter<RectifiedGrid> {

    @Override
    public RectifiedGrid createObject(QName name) throws ObjectBuildException {
        return new RectifiedGrid();
    }

    @Override
    public void buildChildObject(RectifiedGrid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "origin":
                    object.setOrigin(reader.getObjectUsingBuilder(PointPropertyAdapter.class));
                    break;
                case "offsetVector":
                    object.getOffsetVectors().add(reader.getObjectUsingBuilder(VectorAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }    }

    @Override
    public Element createElement(RectifiedGrid object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "RectifiedGrid");
    }

    @Override
    public void writeChildElements(RectifiedGrid object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getOrigin() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "origin"), object.getOrigin(), PointPropertyAdapter.class, namespaces);

        for (Vector offsetVector : object.getOffsetVectors())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "offsetVector"), offsetVector, VectorAdapter.class, namespaces);
    }
}
