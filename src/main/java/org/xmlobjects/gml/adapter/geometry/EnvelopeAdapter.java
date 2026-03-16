/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CoordinatesAdapter;
import org.xmlobjects.gml.adapter.deprecated.CoordAdapter;
import org.xmlobjects.gml.model.deprecated.Coord;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;
import java.util.List;

@XMLElements({
        @XMLElement(name = "Envelope", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Envelope", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class EnvelopeAdapter implements ObjectBuilder<Envelope>, ObjectSerializer<Envelope> {

    @Override
    public Envelope createObject(QName name, Object parent) throws ObjectBuildException {
        return new Envelope();
    }

    @Override
    public void initializeObject(Envelope object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        GMLBuilderHelper.buildSRSReference(object, attributes);
    }

    @Override
    public void buildChildObject(Envelope object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "lowerCorner":
                    object.setLowerCorner(reader.getObjectUsingBuilder(DirectPositionAdapter.class));
                    break;
                case "upperCorner":
                    object.setUpperCorner(reader.getObjectUsingBuilder(DirectPositionAdapter.class));
                    break;
                case "pos":
                    DirectPosition pos = reader.getObjectUsingBuilder(DirectPositionAdapter.class);
                    if (!object.isSetLowerCorner())
                        object.setLowerCorner(pos);
                    else if (!object.isSetUpperCorner())
                        object.setUpperCorner(pos);
                    break;
                case "coordinates":
                    List<DirectPosition> positions = reader.getObjectUsingBuilder(CoordinatesAdapter.class).toDirectPositions();
                    if (positions.size() > 1) {
                        object.setLowerCorner(positions.get(0));
                        object.setUpperCorner(positions.get(1));
                    }
                    break;
                case "coord":
                    Coord coord = reader.getObjectUsingBuilder(CoordAdapter.class);
                    if (!object.isSetLowerCorner())
                        object.setLowerCorner(coord.toDirectPosition());
                    else if (!object.isSetUpperCorner())
                        object.setUpperCorner(coord.toDirectPosition());
                    break;
            }
        }
    }

    @Override
    public Element createElement(Envelope object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "Envelope");
    }

    @Override
    public void initializeElement(Element element, Envelope object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        GMLSerializerHelper.serializeSRSReference(element, object, namespaces);
    }

    @Override
    public void writeChildElements(Envelope object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.isSetLowerCorner())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "lowerCorner"), object.getLowerCorner(), DirectPositionAdapter.class, namespaces);

        if (object.isSetUpperCorner())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "upperCorner"), object.getUpperCorner(), DirectPositionAdapter.class, namespaces);
    }
}
