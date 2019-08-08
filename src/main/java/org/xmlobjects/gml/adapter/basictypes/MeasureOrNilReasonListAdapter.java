package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.MeasureOrNilReasonList;
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

public class MeasureOrNilReasonListAdapter implements ObjectBuilder<MeasureOrNilReasonList>, ObjectSerializer<MeasureOrNilReasonList> {

    @Override
    public MeasureOrNilReasonList createObject(QName name, Properties properties) {
        return new MeasureOrNilReasonList();
    }

    @Override
    public void initializeObject(MeasureOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(DoubleOrNilReasonListAdapter.class).initializeObject(object, name, attributes, reader);
        attributes.getValue("uom").ifPresent(object::setUom);
    }

    @Override
    public void initializeElement(Element element, MeasureOrNilReasonList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(DoubleOrNilReasonListAdapter.class).initializeElement(element, object, namespaces, writer);
        element.addAttribute("uom", object.getUom());
    }
}
