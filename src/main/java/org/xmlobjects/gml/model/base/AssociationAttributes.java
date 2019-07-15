package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.xlink.ActuateType;
import org.xmlobjects.gml.model.xlink.ShowType;

public interface AssociationAttributes {
    String getType();
    String getHref();
    void setHref(String href);
    String getRole();
    void setRole(String role);
    String getArcRole();
    void setArcRole(String arcRole);
    String getTitle();
    void setTitle(String title);
    ShowType getShow();
    void setShow(ShowType show);
    ActuateType getActuate();
    void setActuate(ActuateType actuate);
    String getNilReason();
    void setNilReason(String nilReason);
    String getRemoteSchema();
    void setRemoteSchema(String remoteSchema);
}
