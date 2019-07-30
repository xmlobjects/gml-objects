package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.common.SerializerHelper;
import org.xmlobjects.gml.model.geometry.primitives.Curve;
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
        @XMLElement(name = "Curve", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Curve", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class CurveAdapter extends AbstractCurveAdapter<Curve> {

    @Override
    public Curve createObject(QName name) {
        return new Curve();
    }

    @Override
    public void buildChildObject(Curve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("segments".equals(name.getLocalPart()))
            object.setSegments(reader.getObjectUsingBuilder(CurveSegmentArrayPropertyAdapter.class));
    }

    @Override
    public Element createElement(Curve object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "Curve");
    }

    @Override
    public void writeChildElements(Curve object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getSegments() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "segments"), object.getSegments(), CurveSegmentArrayPropertyAdapter.class, namespaces);
    }
}
