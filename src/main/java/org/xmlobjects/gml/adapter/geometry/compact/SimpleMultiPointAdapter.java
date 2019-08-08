package org.xmlobjects.gml.adapter.geometry.compact;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.DirectPositionListAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.AbstractGeometricAggregateAdapter;
import org.xmlobjects.gml.model.geometry.compact.SimpleMultiPoint;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "SimpleMultiPoint", namespaceURI = GMLObjects.GML_3_3_CE_NAMESPACE)
public class SimpleMultiPointAdapter extends AbstractGeometricAggregateAdapter<SimpleMultiPoint> {

    @Override
    public SimpleMultiPoint createObject(QName name) {
        return new SimpleMultiPoint();
    }

    @Override
    public void buildChildObject(SimpleMultiPoint object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            if ("posList".equals(name.getLocalPart()))
                object.setPosList(reader.getObjectUsingBuilder(DirectPositionListAdapter.class));
            else
                super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(SimpleMultiPoint object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "SimpleMultiPoint");
    }

    @Override
    public void writeChildElements(SimpleMultiPoint object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getPosList() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "posList"), object.getPosList(), DirectPositionListAdapter.class, namespaces);
    }
}
