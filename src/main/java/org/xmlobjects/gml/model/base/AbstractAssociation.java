/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.LocalProperties;
import org.xmlobjects.model.Child;

public abstract class AbstractAssociation<T extends Child> extends GMLObject {
    private LocalProperties localProperties;

    public abstract Class<T> getTargetType();

    public boolean hasLocalProperties() {
        return localProperties != null && !localProperties.isEmpty();
    }

    public LocalProperties getLocalProperties() {
        if (localProperties == null)
            localProperties = new LocalProperties();

        return localProperties;
    }

    public void setLocalProperties(LocalProperties localProperties) {
        this.localProperties = localProperties;
    }
}
