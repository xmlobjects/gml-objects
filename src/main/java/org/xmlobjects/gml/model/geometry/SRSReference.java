package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.feature.AbstractFeature;

public interface SRSReference extends SRSInformation {
    String getSrsName();
    void setSrsName(String srsName);
    Integer getSrsDimension();
    void setSrsDimension(Integer srsDimension);

    default SRSReference getInheritedSRSReference() {
        if (getSrsName() == null && this instanceof GMLObject) {
            GMLObject parent = (GMLObject) this;

            while ((parent = parent.getParent()) != null) {
                if (parent instanceof AbstractGeometry)
                    return ((AbstractGeometry) parent).getInheritedSRSReference();
                else if (parent instanceof AbstractFeature) {
                    AbstractFeature feature = (AbstractFeature) parent;
                    if (feature.getBoundedBy() != null
                            && feature.getBoundedBy().getEnvelope() != null
                            && feature.getBoundedBy().getEnvelope().getSrsName() != null)
                        return feature.getBoundedBy().getEnvelope();
                }
            }
        }

        return this;
    }
}
