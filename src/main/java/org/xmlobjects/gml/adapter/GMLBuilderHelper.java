/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2022 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.OwnershipAttributes;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.geometry.SRSInformation;
import org.xmlobjects.gml.model.geometry.SRSReference;
import org.xmlobjects.gml.model.valueobjects.ReferenceSystem;
import org.xmlobjects.gml.model.xlink.ActuateType;
import org.xmlobjects.gml.model.xlink.ShowType;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Attributes;

public class GMLBuilderHelper {

    public static boolean isGMLNamespace(String namespaceURI) {
        return GMLConstants.GML_3_2_NAMESPACE.equals(namespaceURI)
                || GMLConstants.GML_3_1_NAMESPACE.equals(namespaceURI)
                || GMLConstants.GML_3_3_XBT_NAMESPACE.equals(namespaceURI)
                || GMLConstants.GML_3_3_CE_NAMESPACE.equals(namespaceURI);
    }

    public static void buildAssociationAttributes(AssociationAttributes object, Attributes attributes) {
        attributes.getValue(GMLConstants.XLINK_NAMESPACE, "href").ifPresent(object::setHref);
        attributes.getValue(GMLConstants.XLINK_NAMESPACE, "role").ifPresent(object::setRole);
        attributes.getValue(GMLConstants.XLINK_NAMESPACE, "arcrole").ifPresent(object::setArcRole);
        attributes.getValue(GMLConstants.XLINK_NAMESPACE, "title").ifPresent(object::setTitle);
        attributes.getValue(GMLConstants.XLINK_NAMESPACE, "show").ifPresent(v -> object.setShow(ShowType.fromValue(v)));
        attributes.getValue(GMLConstants.XLINK_NAMESPACE, "actuate").ifPresent(v -> object.setActuate(ActuateType.fromValue(v)));
        attributes.getValue(GMLConstants.GML_3_1_NAMESPACE, "remoteSchema").ifPresent(object::setRemoteSchema);
        attributes.getValue(GMLConstants.GML_3_2_NAMESPACE, "remoteSchema").ifPresent(object::setRemoteSchema);
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