package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.geometry.primitives.CurveArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.CurvePropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "MultiCurve", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "MultiCurve", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class MultiCurveBuilder extends AbstractGeometricAggregateBuilder<MultiCurve> {

    @Override
    public MultiCurve createObject(QName name) {
        return new MultiCurve();
    }

    @Override
    public void buildNestedObject(MultiCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "curveMember":
                object.getCurveMember().add(reader.getObjectUsingBuilder(CurvePropertyBuilder.class));
                break;
            case "curveMembers":
                object.setCurveMembers(reader.getObjectUsingBuilder(CurveArrayPropertyBuilder.class));
                break;
        }
    }
}
