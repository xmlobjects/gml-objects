package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
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
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class RangeSetAdapter implements ObjectBuilder<RangeSet>, ObjectSerializer<RangeSet> {

    @Override
    public RangeSet createObject(QName name) {
        return new RangeSet();
    }

    @Override
    public void buildChildObject(RangeSet object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
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
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

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
