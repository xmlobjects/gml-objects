package org.xmlobjects.gml.builder.geometry.complexes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.geometry.AbstractGeometryBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.GeometricPrimitivePropertyBuilder;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplex;
import org.xmlobjects.gml.model.geometry.primitives.GeometricPrimitiveProperty;
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
        BuilderHelper.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(GeometricComplex object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("element".equals(name.getLocalPart()))
            object.getElements().add(reader.getObjectUsingBuilder(GeometricPrimitivePropertyBuilder.class));
    }

    @Override
    public Element createElement(GeometricComplex object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "GeometricComplex");
    }

    @Override
    public void initializeElement(Element element, GeometricComplex object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        SerializerHelper.serializeAggregationAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(GeometricComplex object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        for (GeometricPrimitiveProperty property : object.getElements())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "element"), property, GeometricPrimitivePropertyBuilder.class, namespaces);
    }
}
