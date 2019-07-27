package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.model.basicTypes.Sign;
import org.xmlobjects.gml.model.geometry.primitives.OrientableSurface;
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
        @XMLElement(name = "OrientableSurface", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "OrientableSurface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class OrientableSurfaceBuilder extends AbstractSurfaceBuilder<OrientableSurface> {

    @Override
    public OrientableSurface createObject(QName name) {
        return new OrientableSurface();
    }

    @Override
    public void initializeObject(OrientableSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("orientation").ifPresent(v -> object.setOrientation(Sign.fromValue(v)));
    }

    @Override
    public void buildChildObject(OrientableSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("baseSurface".equals(name.getLocalPart()))
            object.setBaseSurface(reader.getObjectUsingBuilder(SurfacePropertyBuilder.class));
    }

    @Override
    public Element createElement(OrientableSurface object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "OrientableSurface");
    }

    @Override
    public void initializeElement(Element element, OrientableSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);

        if (object.getOrientation() != Sign.PLUS)
            element.addAttribute("orientation", object.getOrientation().toValue());
    }

    @Override
    public void writeChildElements(OrientableSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getBaseSurface() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "baseSurface"), object.getBaseSurface(), SurfacePropertyBuilder.class, namespaces);
    }
}
