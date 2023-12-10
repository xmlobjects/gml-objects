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

package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.xlink.ActuateType;
import org.xmlobjects.gml.model.xlink.ShowType;
import org.xmlobjects.gml.util.id.DefaultIdCreator;
import org.xmlobjects.model.Child;

public abstract class AbstractReference<T extends Child> extends AbstractAssociation<T> implements ResolvableAssociation<T>, OwnershipAttributes {
    private T referencedObject;
    private String href;
    private String role;
    private String arcRole;
    private String title;
    private ShowType show;
    private ActuateType actuate;
    private NilReason nilReason;
    private String remoteSchema;
    private Boolean owns;

    public AbstractReference() {
    }

    public AbstractReference(String href) {
        this.href = href;
    }

    public AbstractReference(T object) {
        setReferencedObject(object);
    }

    public AbstractReference(AssociationAttributes reference) {
        setReference(reference);
    }

    @Override
    public boolean isSetReferencedObject() {
        return referencedObject != null;
    }

    public T getReferencedObject() {
        return referencedObject;
    }

    @Override
    public void setReferencedObject(T object) {
        setReferencedObject(object, true);
    }

    @Override
    public void setReferencedObject(T object, boolean updateReference) {
        referencedObject = object;

        if (updateReference && object instanceof AbstractGML gml) {
            if (gml.getId() == null) {
                gml.setId(DefaultIdCreator.getInstance().createId());
            }

            setHref('#' + gml.getId());
        }
    }

    @Override
    public void setReferencedObjectIfValid(Child object) {
        setReferencedObjectIfValid(object, true);
    }

    @Override
    public void setReferencedObjectIfValid(Child object, boolean updateReference) {
        if (object == null || getTargetType().isInstance(object)) {
            setReferencedObject(getTargetType().cast(object), updateReference);
        }
    }

    @Override
    public final String getType() {
        return "simple";
    }

    @Override
    public String getHref() {
        return href;
    }

    @Override
    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getArcRole() {
        return arcRole;
    }

    @Override
    public void setArcRole(String arcRole) {
        this.arcRole = arcRole;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public ShowType getShow() {
        return show;
    }

    @Override
    public void setShow(ShowType show) {
        this.show = show;
    }

    @Override
    public ActuateType getActuate() {
        return actuate;
    }

    @Override
    public void setActuate(ActuateType actuate) {
        this.actuate = actuate;
    }

    @Override
    public NilReason getNilReason() {
        return nilReason;
    }

    @Override
    public void setNilReason(NilReason nilReason) {
        this.nilReason = asChild(nilReason);
    }

    @Override
    public String getRemoteSchema() {
        return remoteSchema;
    }

    @Override
    public void setRemoteSchema(String remoteSchema) {
        this.remoteSchema = remoteSchema;
    }

    @Override
    public Boolean getOwns() {
        return owns;
    }

    @Override
    public void setOwns(Boolean owns) {
        this.owns = owns;
    }
}
