/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.basictypes.NilReason;
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

    NilReason getNilReason();

    void setNilReason(NilReason nilReason);

    String getRemoteSchema();

    void setRemoteSchema(String remoteSchema);

    default void setReference(AssociationAttributes reference) {
        if (reference != null) {
            setHref(reference.getHref());
            setRole(reference.getRole());
            setArcRole(reference.getArcRole());
            setTitle(reference.getTitle());
            setShow(reference.getShow());
            setActuate(reference.getActuate());
            setNilReason(reference.getNilReason());
            setRemoteSchema(reference.getRemoteSchema());
        } else {
            setHref(null);
            setRole(null);
            setArcRole(null);
            setTitle(null);
            setShow(null);
            setActuate(null);
            setNilReason(null);
            setRemoteSchema(null);
        }
    }
}
