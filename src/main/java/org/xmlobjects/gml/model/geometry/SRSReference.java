/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2023 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.model.Child;

public interface SRSReference extends SRSInformation {
    String getSrsName();
    void setSrsName(String srsName);
    Integer getSrsDimension();
    void setSrsDimension(Integer srsDimension);

    default SRSReference getInheritedSRSReference() {
        if (getSrsName() == null && this instanceof Child) {
            Child parent = ((Child) this).getParent();
            if (parent != null) {
                do {
                    if (parent instanceof AbstractGeometry)
                        return ((AbstractGeometry) parent).getInheritedSRSReference();
                    else if (parent instanceof AbstractFeature) {
                        AbstractFeature feature = (AbstractFeature) parent;
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
