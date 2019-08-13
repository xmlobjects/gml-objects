package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.basictypes.Sign;
import org.xmlobjects.gml.model.geometry.primitives.OrientableCurve;
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
        @XMLElement(name = "OrientableCurve", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "OrientableCurve", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class OrientableCurveAdapter extends AbstractCurveAdapter<OrientableCurve> {

    @Override
    public OrientableCurve createObject(QName name) {
        return new OrientableCurve();
    }

    @Override
    public void initializeObject(OrientableCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("orientation").ifPresent(v -> object.setOrientation(Sign.fromValue(v)));
    }

    @Override
    public void buildChildObject(OrientableCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            if ("baseCurve".equals(name.getLocalPart()))
                object.setBaseCurve(reader.getObjectUsingBuilder(CurvePropertyAdapter.class));
            else
                super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(OrientableCurve object, Namespaces namespaces) {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "OrientableCurve");
    }

    @Override
    public void initializeElement(Element element, OrientableCurve object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);

        if (object.getOrientation() != Sign.PLUS)
            element.addAttribute("orientation", object.getOrientation().toValue());
    }

    @Override
    public void writeChildElements(OrientableCurve object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getBaseCurve() != null)
            writer.writeElementUsingSerializer(Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "baseCurve"), object.getBaseCurve(), CurvePropertyAdapter.class, namespaces);
    }
}
