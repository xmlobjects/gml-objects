package org.xmlobjects.gml.builder.geometry.complexes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.AttributesBuilder;
import org.xmlobjects.gml.builder.geometry.AbstractGeometryBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.GeometricPrimitivePropertyBuilder;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplex;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "GeometricComplex", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "GeometricComplex", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class GeometricComplexBuilder extends AbstractGeometryBuilder<GeometricComplex> {

    @Override
    public GeometricComplex createObject(QName name) {
        return new GeometricComplex();
    }

    @Override
    public void initializeObject(GeometricComplex object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        AttributesBuilder.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(GeometricComplex object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("element".equals(name.getLocalPart()))
            object.getElements().add(reader.getObjectUsingBuilder(GeometricPrimitivePropertyBuilder.class));
    }

    @Override
    public Element createElement(GeometricComplex object, Namespaces namespaces) {
        return (namespaces.contains(GMLConstants.GML_3_1_NAMESPACE_URI)) ?
                Element.of(GMLConstants.GML_3_1_NAMESPACE_URI, "GeometricComplex") :
                Element.of(GMLConstants.GML_3_2_NAMESPACE_URI, "GeometricComplex");
    }
}
