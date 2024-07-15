/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2024 Claus Nagel <claus.nagel@gmail.com>
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
