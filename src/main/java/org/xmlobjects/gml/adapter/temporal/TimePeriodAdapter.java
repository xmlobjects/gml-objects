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

package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.temporal.TimePeriod;
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
        @XMLElement(name = "TimePeriod", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "TimePeriod", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class TimePeriodAdapter extends AbstractTimeGeometricPrimitiveAdapter<TimePeriod> {

    @Override
    public TimePeriod createObject(QName name) throws ObjectBuildException {
        return new TimePeriod();
    }

    @Override
    public void buildChildObject(TimePeriod object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "beginPosition":
                    object.setBeginPosition(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    break;
                case "begin":
                    object.setBegin(reader.getObjectUsingBuilder(TimeInstantPropertyAdapter.class));
                    break;
                case "endPosition":
                    object.setEndPosition(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    break;
                case "end":
                    object.setEnd(reader.getObjectUsingBuilder(TimeInstantPropertyAdapter.class));
                    break;
                case "duration":
                    object.setDuration(reader.getObjectUsingBuilder(TimeDurationAdapter.class));
                    break;
                case "timeInterval":
                    object.setTimeInterval(reader.getObjectUsingBuilder(TimeIntervalLengthAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(TimePeriod object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "TimePeriod");
    }

    @Override
    public void writeChildElements(TimePeriod object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.isSetBeginPosition())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "beginPosition"), object.getBeginPosition(), TimePositionAdapter.class, namespaces);
        else if (object.isSetBegin())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "begin"), object.getBegin(), TimeInstantPropertyAdapter.class, namespaces);

        if (object.isSetEndPosition())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "endPosition"), object.getEndPosition(), TimePositionAdapter.class, namespaces);
        else if (object.isSetEnd())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "end"), object.getEnd(), TimeInstantPropertyAdapter.class, namespaces);

        if (object.isSetDuration())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "duration"), object.getDuration(), TimeDurationAdapter.class, namespaces);
        else if (object.isSetTimeInterval())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "timeInterval"), object.getTimeInterval(), TimeIntervalLengthAdapter.class, namespaces);
    }
}
