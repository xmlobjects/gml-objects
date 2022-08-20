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

package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CoordinatesAdapter;
import org.xmlobjects.gml.adapter.basictypes.DoubleOrNilReasonListAdapter;
import org.xmlobjects.gml.model.coverage.DataBlock;
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

public class DataBlockAdapter implements ObjectBuilder<DataBlock>, ObjectSerializer<DataBlock> {

    @Override
    public DataBlock createObject(QName name, Object parent) throws ObjectBuildException {
        return new DataBlock();
    }

    @Override
    public void buildChildObject(DataBlock object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "rangeParameters":
                    object.setRangeParameters(reader.getObjectUsingBuilder(RangeParametersAdapter.class));
                    break;
                case "tupleList":
                    object.setTupleList(reader.getObjectUsingBuilder(CoordinatesAdapter.class));
                    break;
                case "doubleOrNilReasonTupleList":
                    object.setDoubleOrNilReasonTupleList(reader.getObjectUsingBuilder(DoubleOrNilReasonListAdapter.class));
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(DataBlock object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getRangeParameters() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "rangeParameters"), object.getRangeParameters(), RangeParametersAdapter.class, namespaces);

        if (object.isSetTupleList())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "tupleList"), object.getTupleList(), CoordinatesAdapter.class, namespaces);
        else if (object.isSetDoubleOrNilReasonTupleList())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "doubleOrNilReasonTupleList"), object.getDoubleOrNilReasonTupleList(), DoubleOrNilReasonListAdapter.class, namespaces);
    }
}
