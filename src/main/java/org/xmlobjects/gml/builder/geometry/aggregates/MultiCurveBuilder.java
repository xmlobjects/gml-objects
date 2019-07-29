package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.geometry.primitives.CurveArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.CurvePropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;
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
        @XMLElement(name = "MultiCurve", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "MultiCurve", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class MultiCurveBuilder extends AbstractGeometricAggregateBuilder<MultiCurve> {

    @Override
    public MultiCurve createObject(QName name) {
        return new MultiCurve();
    }

    @Override
    public void buildChildObject(MultiCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "curveMember":
                object.getCurveMember().add(reader.getObjectUsingBuilder(CurvePropertyBuilder.class));
                break;
            case "curveMembers":
                object.setCurveMembers(reader.getObjectUsingBuilder(CurveArrayPropertyBuilder.class));
                break;
        }
    }

    @Override
    public Element createElement(MultiCurve object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "MultiCurve");
    }

    @Override
    public void writeChildElements(MultiCurve object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        for (CurveProperty property : object.getCurveMember())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "curveMember"), property, CurvePropertyBuilder.class, namespaces);

        if (object.getCurveMembers() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "curveMembers"), object.getCurveMembers(), CurveArrayPropertyBuilder.class, namespaces);
    }
}
