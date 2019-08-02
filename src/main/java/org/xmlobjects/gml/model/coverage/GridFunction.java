package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.GMLObject;

import java.util.List;

public class GridFunction extends GMLObject {
    private SequenceRule sequenceRule;
    private List<Integer> startPoints;

    public GridFunction() {
    }

    public SequenceRule getSequenceRule() {
        return sequenceRule;
    }

    public void setSequenceRule(SequenceRule sequenceRule) {
        this.sequenceRule = asChild(sequenceRule);
    }

    public List<Integer> getStartPoints() {
        return startPoints;
    }

    public void setStartPoints(List<Integer> startPoints) {
        this.startPoints = startPoints;
    }
}
