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

package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.Surface;
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
        @XMLElement(name = "Surface", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Surface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class SurfaceAdapter extends AbstractSurfaceAdapter<Surface> {

    @Override
    public Surface createObject(QName name, Object parent) throws ObjectBuildException {
        return new Surface();
    }

    @Override
    public void buildChildObject(Surface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "patches":
                    object.setPatches(reader.getObjectUsingBuilder(SurfacePatchArrayPropertyAdapter.class));
                    break;
                case "trianglePatches":
                    object.setPatches(reader.getObjectUsingBuilder(TriangleArrayPropertyAdapter.class));
                    break;
                case "polygonPatches":
                    object.setPatches(reader.getObjectUsingBuilder(PolygonPatchArrayPropertyAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(Surface object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "Surface");
    }

    @Override
    public void writeChildElements(Surface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getPatches() != null)
            writer.writeElementUsingSerializer(Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "patches"), object.getPatches(), SurfacePatchArrayPropertyAdapter.class, namespaces);
    }
}
