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

package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.Shell;
import org.xmlobjects.gml.model.geometry.primitives.ShellProperty;
import org.xmlobjects.gml.model.geometry.primitives.Solid;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
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
        @XMLElement(name = "Solid", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Solid", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class SolidAdapter extends AbstractSolidAdapter<Solid> {

    @Override
    public Solid createObject(QName name, Object parent) throws ObjectBuildException {
        return new Solid();
    }

    @Override
    public void buildChildObject(Solid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "exterior":
                    object.setExterior(getShellProperty(reader));
                    break;
                case "interior":
                    object.getInterior().add(getShellProperty(reader));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(Solid object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "Solid");
    }

    @Override
    public void writeChildElements(Solid object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getExterior() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "exterior"), object.getExterior(), ShellPropertyAdapter.class, namespaces);

        if (object.isSetInterior()) {
            for (ShellProperty property : object.getInterior())
                writer.writeElementUsingSerializer(Element.of(baseNamespace, "interior"), property, ShellPropertyAdapter.class, namespaces);
        }
    }

    private ShellProperty getShellProperty(XMLReader reader) throws ObjectBuildException, XMLReadException {
        Shell shell = null;

        SurfaceProperty surfaceProperty = reader.getObjectUsingBuilder(SurfacePropertyAdapter.class);
        if (surfaceProperty.getObject() instanceof Shell surface)
            shell = surface;
        else if (surfaceProperty.getObject() instanceof CompositeSurface surface)
            shell = new Shell(surface);

        return new ShellProperty(shell);
    }
}
