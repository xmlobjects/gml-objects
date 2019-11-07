package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractTimePrimitive extends AbstractTimeObject {
    private List<RelatedTime> relatedTimes;

    public List<RelatedTime> getRelatedTimes() {
        if (relatedTimes == null)
            relatedTimes = new ChildList<>(this);

        return relatedTimes;
    }

    public void setRelatedTimes(List<RelatedTime> relatedTimes) {
        this.relatedTimes = asChild(relatedTimes);
    }
}
