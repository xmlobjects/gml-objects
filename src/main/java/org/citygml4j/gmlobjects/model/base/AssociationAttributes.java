package org.citygml4j.gmlobjects.model.base;

import org.citygml4j.gmlobjects.model.basicTypes.NilReason;
import org.citygml4j.gmlobjects.model.xlink.ActuateType;
import org.citygml4j.gmlobjects.model.xlink.ShowType;

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
    NilReason getNilReason();
    void setNilReason(NilReason nilReason);
    String getRemoteSchema();
    void setRemoteSchema(String remoteSchema);
}
