package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.Child;
import org.xmlobjects.gml.model.feature.AbstractFeature;

public interface SRSReference extends SRSInformation {
    String getSrsName();
    void setSrsName(String srsName);
    Integer getSrsDimension();
    void setSrsDimension(Integer srsDimension);

    default SRSReference getInheritedSRSReference() {
        if (getSrsName() == null && this instanceof Child) {
            GMLObject parent = ((Child) this).getParent();
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
