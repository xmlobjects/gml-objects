package org.xmlobjects.gml.adapter.geometry.grids;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.geometry.grids.GridLimits;
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

public class GridLimitsAdapter implements ObjectBuilder<GridLimits>, ObjectSerializer<GridLimits> {

    @Override
    public GridLimits createObject(QName name) {
        return new GridLimits();
    }

    @Override
    public void buildChildObject(GridLimits object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if ("GridEnvelope".equals(name.getLocalPart()) && BuilderHelper.isGMLNamespace(name.getNamespaceURI()))
            object.setGridEnvelope(reader.getObjectUsingBuilder(GridEnvelopeAdapter.class));
    }

    @Override
    public void writeChildElements(GridLimits object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getGridEnvelope() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "GridEnvelope"), object.getGridEnvelope(), GridEnvelopeAdapter.class, namespaces);
    }
}
