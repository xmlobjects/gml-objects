package org.xmlobjects.gml.builder.basictypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.MeasureList;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class MeasureListBuilder implements ObjectBuilder<MeasureList>, ObjectSerializer<MeasureList> {

    @Override
    public MeasureList createObject(QName name) {
        return new MeasureList();
    }

    @Override
    public void initializeObject(MeasureList object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifDoubleList(object::setValue);
        attributes.getValue("uom").ifPresent(object::setUom);
    }

    @Override
    public void initializeElement(Element element, MeasureList object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(TextContent.ofDoubleList(object.getValue()));
        element.addAttribute("uom", object.getUom());
    }
}
