package org.xmlobjects.gml.adapter.geometry.complexes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.primitives.AbstractCurveAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.CurvePropertyAdapter;
import org.xmlobjects.gml.model.geometry.complexes.CompositeCurve;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;
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
        @XMLElement(name = "CompositeCurve", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "CompositeCurve", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class CompositeCurveAdapter extends AbstractCurveAdapter<CompositeCurve> {

    @Override
    public CompositeCurve createObject(QName name) {
        return new CompositeCurve();
    }

    @Override
    public void initializeObject(CompositeCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        BuilderHelper.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(CompositeCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            if ("curveMember".equals(name.getLocalPart()))
                object.getCurveMembers().add(reader.getObjectUsingBuilder(CurvePropertyAdapter.class));
            else
                super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(CompositeCurve object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CompositeCurve");
    }

    @Override
    public void initializeElement(Element element, CompositeCurve object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        SerializerHelper.serializeAggregationAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(CompositeCurve object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        for (CurveProperty property : object.getCurveMembers())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "curveMember"), property, CurvePropertyAdapter.class, namespaces);
    }
}
