package org.xmlobjects.gml.adapter;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.OwnershipAttributes;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.geometry.SRSInformation;
import org.xmlobjects.gml.model.geometry.SRSReference;
import org.xmlobjects.gml.model.valueobjects.ReferenceSystem;
import org.xmlobjects.gml.model.xlink.ActuateType;
import org.xmlobjects.gml.model.xlink.ShowType;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.xml.Attributes;

public class BuilderHelper {

    public static boolean isGMLBaseNamespace(String namespaceURI) {
        return GMLObjects.GML_3_2_NAMESPACE.equals(namespaceURI)
                || GMLObjects.GML_3_1_NAMESPACE.equals(namespaceURI);
    }

    public static void buildAssociationAttributes(AssociationAttributes object, Attributes attributes) {
        attributes.getValue(GMLObjects.XLINK_NAMESPACE, "href").ifPresent(object::setHref);
        attributes.getValue(GMLObjects.XLINK_NAMESPACE, "role").ifPresent(object::setRole);
        attributes.getValue(GMLObjects.XLINK_NAMESPACE, "arcrole").ifPresent(object::setArcRole);
        attributes.getValue(GMLObjects.XLINK_NAMESPACE, "title").ifPresent(object::setTitle);
        attributes.getValue(GMLObjects.XLINK_NAMESPACE, "show").ifPresent(v -> object.setShow(ShowType.fromValue(v)));
        attributes.getValue(GMLObjects.XLINK_NAMESPACE, "actuate").ifPresent(v -> object.setActuate(ActuateType.fromValue(v)));
        attributes.getValue(GMLObjects.GML_3_1_NAMESPACE, "remoteSchema").ifPresent(object::setRemoteSchema);
        attributes.getValue(GMLObjects.GML_3_2_NAMESPACE, "remoteSchema").ifPresent(object::setRemoteSchema);
        attributes.getValue("nilReason").ifPresent(v -> object.setNilReason(new NilReason(v)));
    }

    public static void buildOwnershipAttributes(OwnershipAttributes object, Attributes attributes) {
        attributes.getValue("owns").ifBoolean(object::setOwns);
    }

    public static void buildAggregationAttributes(AggregationAttributes object, Attributes attributes) {
        attributes.getValue("aggregationType").ifPresent(v -> object.setAggregationType(AggregationType.fromValue(v)));
    }

    public static void buildSRSReference(SRSReference object, Attributes attributes) {
        attributes.getValue("srsName").ifPresent(object::setSrsName);
        attributes.getValue("srsDimension").ifInteger(object::setSrsDimension);
        buildSRSInformation(object, attributes);
    }

    public static void buildSRSInformation(SRSInformation object, Attributes attributes) {
        attributes.getValue("axisLabels").ifList(object::setAxisLabels);
        attributes.getValue("uomLabels").ifList(object::setAxisLabels);
    }

    public static void buildReferenceSystem(ReferenceSystem object, Attributes attributes) {
        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
        attributes.getValue("uom").ifPresent(object::setUom);
    }
}