/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractTimePrimitive extends AbstractTimeObject {
    private List<RelatedTime<?>> relatedTimes;

    public List<RelatedTime<?>> getRelatedTimes() {
        if (relatedTimes == null)
            relatedTimes = new ChildList<>(this);

        return relatedTimes;
    }

    public boolean isSetRelatedTimes() {
        return relatedTimes != null && !relatedTimes.isEmpty();
    }

    public void setRelatedTimes(List<RelatedTime<?>> relatedTimes) {
        this.relatedTimes = asChild(relatedTimes);
    }
}
