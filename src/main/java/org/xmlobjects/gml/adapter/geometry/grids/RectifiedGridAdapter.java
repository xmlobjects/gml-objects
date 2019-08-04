package org.xmlobjects.gml.adapter.geometry.grids;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.VectorAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.PointPropertyAdapter;
import org.xmlobjects.gml.model.geometry.Vector;
import org.xmlobjects.gml.model.geometry.grids.RectifiedGrid;
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
        @XMLElement(name = "RectifiedGrid", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "RectifiedGrid", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class RectifiedGridAdapter extends AbstractGridAdapter<RectifiedGrid> {

    @Override
    public RectifiedGrid createObject(QName name) {
        return new RectifiedGrid();
    }

    @Override
    public void buildChildObject(RectifiedGrid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "origin":
                    object.setOrigin(reader.getObjectUsingBuilder(PointPropertyAdapter.class));
                    break;
                case "offsetVector":
                    object.getOffsetVectors().add(reader.getObjectUsingBuilder(VectorAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }    }

    @Override
    public Element createElement(RectifiedGrid object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "RectifiedGrid");
    }

    @Override
    public void writeChildElements(RectifiedGrid object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getOrigin() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "origin"), object.getOrigin(), PointPropertyAdapter.class, namespaces);

        for (Vector offsetVector : object.getOffsetVectors())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "offsetVector"), offsetVector, VectorAdapter.class, namespaces);
    }
}
