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

    default Integer getInheritedSrsDimension() {
        if (getSrsDimension() != null) {
            return getSrsDimension();
        } else if (this instanceof Child child) {
            for (Child parent = child.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof SRSReference reference && reference.getSrsDimension() != null) {
                    return reference.getSrsDimension();
                } else if (parent instanceof AbstractFeature feature
                        && feature.getBoundedBy() != null
                        && feature.getBoundedBy().getEnvelope() != null
                        && feature.getBoundedBy().getEnvelope().getSrsDimension() != null) {
                    return feature.getBoundedBy().getEnvelope().getSrsDimension();
                }
            }
        }

        return null;
    }
}
