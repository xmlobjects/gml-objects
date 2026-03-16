/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.model.Child;

public interface SRSReference extends SRSInformation {
    String getSrsName();

    void setSrsName(String srsName);

    Integer getSrsDimension();

    void setSrsDimension(Integer srsDimension);

    default SRSReference getInheritedSRSReference() {
        if (getSrsName() == null && this instanceof Child child) {
            Child parent = child.getParent();
            if (parent != null) {
                do {
                    if (parent instanceof AbstractGeometry geometry)
                        return geometry.getInheritedSRSReference();
                    else if (parent instanceof AbstractFeature feature) {
                        if (feature.getBoundedBy() != null
                                && feature.getBoundedBy().getEnvelope() != null
                                && feature.getBoundedBy().getEnvelope().getSrsName() != null)
                            return feature.getBoundedBy().getEnvelope();
                    }
                } while ((parent = parent.getParent()) != null);
            }
        }

        return this;
    }
}
