package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.DoubleOrNilReason;
import org.xmlobjects.gml.model.basicTypes.MeasureOrNilReasonList;
import org.xmlobjects.gml.model.basicTypes.NilReason;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class MeasureOrNilReasonListBuilder implements ObjectBuilder<MeasureOrNilReasonList> {

    @Override
    public MeasureOrNilReasonList createObject(QName name) {
        return new MeasureOrNilReasonList();
    }

    @Override
    public void initializeObject(MeasureOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        TextContent content = reader.getTextContent();
        for (String item : content.getAsList()) {
            try {
                object.getValue().add(new DoubleOrNilReason(Double.parseDouble(item)));
            } catch (Throwable e) {
                object.getValue().add(new DoubleOrNilReason(new NilReason(item)));
            }
        }

        attributes.getValue("uom").ifPresent(object::setUom);
    }

    @Override
    public void buildNestedObject(MeasureOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
    }
}