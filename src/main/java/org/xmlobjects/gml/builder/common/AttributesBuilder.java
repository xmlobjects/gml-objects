package org.xmlobjects.gml.builder.common;

import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.OwnershipAttributes;
import org.xmlobjects.gml.model.common.Constants;
import org.xmlobjects.gml.model.geometry.SRSInformation;
import org.xmlobjects.gml.model.geometry.SRSReference;
import org.xmlobjects.gml.model.xlink.ActuateType;
import org.xmlobjects.gml.model.xlink.ShowType;
import org.xmlobjects.xml.Attributes;

public class AttributesBuilder {

    public static void buildAssociationAttributes(AssociationAttributes object, Attributes attributes) {
        attributes.getValue(Constants.XLINK_NAMESPACE_URI, "href").ifPresent(object::setHref);
        attributes.getValue(Constants.XLINK_NAMESPACE_URI, "role").ifPresent(object::setRole);
        attributes.getValue(Constants.XLINK_NAMESPACE_URI, "arcRole").ifPresent(object::setArcRole);
        attributes.getValue(Constants.XLINK_NAMESPACE_URI, "title").ifPresent(object::setTitle);
        attributes.getValue(Constants.XLINK_NAMESPACE_URI, "show").ifPresent(v -> object.setShow(ShowType.fromValue(v)));
        attributes.getValue(Constants.XLINK_NAMESPACE_URI, "actuate").ifPresent(v -> object.setActuate(ActuateType.fromValue(v)));
        attributes.getValue(Constants.GML_3_1_NAMESPACE_URI, "remoteSchema").ifPresent(object::setRemoteSchema);
        attributes.getValue(Constants.GML_3_2_NAMESPACE_URI, "remoteSchema").ifPresent(object::setRemoteSchema);
        attributes.getValue("nilReason").ifPresent(object::setNilReason);
    }

    public static void buildOwnershipAttributes(OwnershipAttributes object, Attributes attributes) {
        attributes.getValue("owns").ifBoolean(object::setOwns);
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
}