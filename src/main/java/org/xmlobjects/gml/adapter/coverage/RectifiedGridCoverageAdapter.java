package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
import org.xmlobjects.gml.model.coverage.RectifiedGridCoverage;
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
        @XMLElement(name = "RectifiedGridCoverage", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "RectifiedGridCoverage", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class RectifiedGridCoverageAdapter extends AbstractFeatureAdapter<RectifiedGridCoverage> {

    @Override
    public RectifiedGridCoverage createObject(QName name) {
        return new RectifiedGridCoverage();
    }

    @Override
    public void buildChildObject(RectifiedGridCoverage object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "domainSet":
                case "rectifiedGridDomain":
                    object.setDomainSet(reader.getObjectUsingBuilder(RectifiedGridDomainAdapter.class));
                    break;
                case "rangeSet":
                    object.setRangeSet(reader.getObjectUsingBuilder(RangeSetAdapter.class));
                    break;
                case "coverageFunction":
                    object.setCoverageFunction(reader.getObjectUsingBuilder(CoverageFunctionAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(RectifiedGridCoverage object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "RectifiedGridCoverage");
    }

    @Override
    public void writeChildElements(RectifiedGridCoverage object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getDomainSet() != null) {
            String localName = GMLObjects.GML_3_2_NAMESPACE.equals(baseNamespace) ? "domainSet" : "rectifiedGridDomain";
            writer.writeElementUsingSerializer(Element.of(baseNamespace, localName), object.getDomainSet(), RectifiedGridDomainAdapter.class, namespaces);
        }

        if (object.getRangeSet() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "rangeSet"), object.getRangeSet(), RangeSetAdapter.class, namespaces);

        if (object.getCoverageFunction() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "coverageFunction"), object.getCoverageFunction(), CoverageFunctionAdapter.class, namespaces);
    }
}
