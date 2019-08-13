package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
import org.xmlobjects.gml.model.coverage.GridCoverage;
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
        @XMLElement(name = "GridCoverage", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "GridCoverage", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class GridCoverageAdapter extends AbstractFeatureAdapter<GridCoverage> {

    @Override
    public GridCoverage createObject(QName name) {
        return new GridCoverage();
    }

    @Override
    public void buildChildObject(GridCoverage object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "domainSet":
                case "gridDomain":
                    object.setDomainSet(reader.getObjectUsingBuilder(GridDomainAdapter.class));
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
    public Element createElement(GridCoverage object, Namespaces namespaces) {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "GridCoverage");
    }

    @Override
    public void writeChildElements(GridCoverage object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getDomainSet() != null) {
            String localName = GMLConstants.GML_3_2_NAMESPACE.equals(baseNamespace) ? "domainSet" : "gridDomain";
            writer.writeElementUsingSerializer(Element.of(baseNamespace, localName), object.getDomainSet(), GridDomainAdapter.class, namespaces);
        }

        if (object.getRangeSet() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "rangeSet"), object.getRangeSet(), RangeSetAdapter.class, namespaces);

        if (object.getCoverageFunction() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "coverageFunction"), object.getCoverageFunction(), CoverageFunctionAdapter.class, namespaces);
    }
}
