/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.adapter;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.OwnershipAttributes;
import org.xmlobjects.gml.model.geometry.SRSInformation;
import org.xmlobjects.gml.model.geometry.SRSReference;
import org.xmlobjects.gml.model.valueobjects.ReferenceSystem;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

public class GMLSerializerHelper {

    public static String getGMLBaseNamespace(Namespaces namespaces) {
        return namespaces.contains(GMLConstants.GML_3_1_NAMESPACE) ?
                GMLConstants.GML_3_1_NAMESPACE : GMLConstants.GML_3_2_NAMESPACE;
    }

    public static void serializeAssociationAttributes(Element element, AssociationAttributes object, Namespaces namespaces) {
        String baseNamespace = getGMLBaseNamespace(namespaces);

        element.addAttribute(GMLConstants.XLINK_NAMESPACE, "href", object.getHref());
        element.addAttribute(GMLConstants.XLINK_NAMESPACE, "role", object.getRole());
        element.addAttribute(GMLConstants.XLINK_NAMESPACE, "arcrole", object.getArcRole());
        element.addAttribute(GMLConstants.XLINK_NAMESPACE, "title", object.getTitle());
        element.addAttribute(baseNamespace, "remoteSchema", object.getRemoteSchema());

        if (object.getShow() != null)
            element.addAttribute(GMLConstants.XLINK_NAMESPACE, "show", object.getShow().toValue());

        if (object.getActuate() != null)
            element.addAttribute(GMLConstants.XLINK_NAMESPACE, "actuate", object.getActuate().toValue());

        if (object.getNilReason() != null && GMLConstants.GML_3_2_NAMESPACE.equals(baseNamespace))
            element.addAttribute("nilReason", object.getNilReason().getValue());
    }

    public static void serializeOwnershipAttributes(Element element, OwnershipAttributes object, Namespaces namespaces) {
        if (GMLConstants.GML_3_2_NAMESPACE.equals(getGMLBaseNamespace(namespaces)))
            element.addAttribute("owns", TextContent.ofBoolean(object.getOwns()));
    }

    public static void serializeAggregationAttributes(Element element, AggregationAttributes object, Namespaces namespaces) {
        if (object.getAggregationType() != null && GMLConstants.GML_3_2_NAMESPACE.equals(getGMLBaseNamespace(namespaces)))
            element.addAttribute("aggregationType", object.getAggregationType().toValue());
    }

    public static void serializeSRSReference(Element element, SRSReference object, Namespaces namespaces) {
        element.addAttribute("srsName", object.getSrsName());
        element.addAttribute("srsDimension", TextContent.ofInteger(object.getSrsDimension()));
        serializeSRSInformation(element, object, namespaces);
    }

    public static void serializeSRSInformation(Element element, SRSInformation object, Namespaces namespaces) {
        if (object.isSetAxisLabels()) {
            element.addAttribute("axisLabels", TextContent.ofList(object.getAxisLabels()));
        }

        if (object.isSetUomLabels()) {
            element.addAttribute("uomLabels", TextContent.ofList(object.getUomLabels()));
        }
    }

    public static void serializeReferenceSystem(Element element, ReferenceSystem object, Namespaces namespaces) {
        element.addAttribute("codeSpace", object.getCodeSpace());
        element.addAttribute("uom", object.getUom());
    }
}
