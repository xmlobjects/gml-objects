package org.xmlobjects.gml.builder.geometry.complexes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.AttributesBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.AbstractCurveBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.CurvePropertyBuilder;
import org.xmlobjects.gml.model.geometry.complexes.CompositeCurve;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CompositeCurve", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "CompositeCurve", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class CompositeCurveBuilder extends AbstractCurveBuilder<CompositeCurve> {

    @Override
    public CompositeCurve createObject(QName name) {
        return new CompositeCurve();
    }

    @Override
    public void initializeObject(CompositeCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        AttributesBuilder.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(CompositeCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("curveMember".equals(name.getLocalPart()))
            object.getCurveMembers().add(reader.getObjectUsingBuilder(CurvePropertyBuilder.class));
    }
}
