package org.xmlobjects.gml.adapter;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.OwnershipAttributes;
import org.xmlobjects.gml.model.geometry.SRSInformation;
import org.xmlobjects.gml.model.geometry.SRSReference;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

public class SerializerHelper {

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

        if (GMLConstants.GML_3_2_NAMESPACE.equals(baseNamespace))
            element.addAttribute("nilReason", object.getNilReason());
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
        element.addAttribute("axisLabels", TextContent.ofList(object.getAxisLabels()));
        element.addAttribute("uomLabels", TextContent.ofList(object.getUomLabels()));
    }
}
