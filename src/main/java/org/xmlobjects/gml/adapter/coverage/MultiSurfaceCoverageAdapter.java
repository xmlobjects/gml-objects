/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2025 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
import org.xmlobjects.gml.model.coverage.MultiSurfaceCoverage;
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
        @XMLElement(name = "MultiSurfaceCoverage", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "MultiSurfaceCoverage", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class MultiSurfaceCoverageAdapter extends AbstractFeatureAdapter<MultiSurfaceCoverage> {

    @Override
    public MultiSurfaceCoverage createObject(QName name, Object parent) throws ObjectBuildException {
        return new MultiSurfaceCoverage();
    }

    @Override
    public void buildChildObject(MultiSurfaceCoverage object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "domainSet":
                case "multiSurfaceDomain":
                    object.setDomainSet(reader.getObjectUsingBuilder(MultiSurfaceDomainAdapter.class));
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
    public Element createElement(MultiSurfaceCoverage object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "MultiSurfaceCoverage");
    }

    @Override
    public void writeChildElements(MultiSurfaceCoverage object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = GMLSerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getDomainSet() != null) {
            String localName = GMLConstants.GML_3_2_NAMESPACE.equals(baseNamespace) ? "domainSet" : "multiSurfaceDomain";
            writer.writeElementUsingSerializer(Element.of(baseNamespace, localName), object.getDomainSet(), MultiSurfaceDomainAdapter.class, namespaces);
        }

        if (object.getRangeSet() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "rangeSet"), object.getRangeSet(), RangeSetAdapter.class, namespaces);

        if (object.getCoverageFunction() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "coverageFunction"), object.getCoverageFunction(), CoverageFunctionAdapter.class, namespaces);
    }
}
