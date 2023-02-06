/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2023 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.geometry.primitives.CurveArrayPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.CurvePropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;
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
        @XMLElement(name = "MultiCurve", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "MultiCurve", namespaceURI = GMLConstants.GML_3_1_NAMESPACE),
        @XMLElement(name = "MultiLineString", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class MultiCurveAdapter extends AbstractGeometricAggregateAdapter<MultiCurve> {

    @Override
    public MultiCurve createObject(QName name, Object parent) throws ObjectBuildException {
        return new MultiCurve();
    }

    @Override
    public void buildChildObject(MultiCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "curveMember":
                case "lineStringMember":
                    object.getCurveMember().add(reader.getObjectUsingBuilder(CurvePropertyAdapter.class));
                    break;
                case "curveMembers":
                    object.setCurveMembers(reader.getObjectUsingBuilder(CurveArrayPropertyAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(MultiCurve object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "MultiCurve");
    }

    @Override
    public void writeChildElements(MultiCurve object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.isSetCurveMember()) {
            for (CurveProperty property : object.getCurveMember())
                writer.writeElementUsingSerializer(Element.of(baseNamespace, "curveMember"), property, CurvePropertyAdapter.class, namespaces);
        }

        if (object.getCurveMembers() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "curveMembers"), object.getCurveMembers(), CurveArrayPropertyAdapter.class, namespaces);
    }
}
