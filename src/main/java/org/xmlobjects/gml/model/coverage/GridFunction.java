/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.GMLObject;

import java.util.ArrayList;
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
        if (startPoints == null) {
            startPoints = new ArrayList<>();
        }

        return startPoints;
    }

    public boolean isSetStartPoints() {
        return startPoints != null && !startPoints.isEmpty();
    }

    public void setStartPoints(List<Integer> startPoints) {
        this.startPoints = startPoints;
    }
}
