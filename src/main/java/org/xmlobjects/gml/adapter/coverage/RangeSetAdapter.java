/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
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

package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.valueobjects.ValueArrayAdapter;
import org.xmlobjects.gml.model.coverage.RangeSet;
import org.xmlobjects.gml.model.valueobjects.AbstractScalarValueList;
import org.xmlobjects.gml.model.valueobjects.ValueArray;
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

public class RangeSetAdapter implements ObjectBuilder<RangeSet>, ObjectSerializer<RangeSet> {

    @Override
    public RangeSet createObject(QName name) throws ObjectBuildException {
        return new RangeSet();
    }

    @Override
    public void buildChildObject(RangeSet object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "ValueArray":
                    object.getValueArrays().add(reader.getObjectUsingBuilder(ValueArrayAdapter.class));
                    break;
                case "DataBlock":
                    object.setDataBlock(reader.getObjectUsingBuilder(DataBlockAdapter.class));
                    break;
                case "File":
                    object.setFile(reader.getObjectUsingBuilder(FileAdapter.class));
                    break;
                default:
                    AbstractScalarValueList value = reader.getObject(AbstractScalarValueList.class);
                    if (value != null)
                        object.getScalarValueLists().add(value);
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(RangeSet object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.isSetValueArrays()) {
            for (ValueArray valueArray : object.getValueArrays())
                writer.writeElementUsingSerializer(Element.of(baseNamespace, "ValueArray"), valueArray, ValueArrayAdapter.class, namespaces);
        } else if (object.isSetDataBlock()) {
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "DataBlock"), object.getDataBlock(), DataBlockAdapter.class, namespaces);
        } else if (object.isSetFile()) {
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "File"), object.getFile(), FileAdapter.class, namespaces);
        } else if (object.isSetScalarValueLists()) {
            for (AbstractScalarValueList valueList : object.getScalarValueLists())
                writer.writeObject(valueList, namespaces);
        }
    }
}
