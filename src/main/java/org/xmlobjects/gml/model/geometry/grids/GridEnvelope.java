package org.xmlobjects.gml.model.geometry.grids;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.Envelope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GridEnvelope extends GMLObject {
    private List<Integer> low;
    private List<Integer> high;

    public GridEnvelope() {
    }

    public GridEnvelope(List<Integer> low, List<Integer> high) {
        this.low = low;
        this.high = high;
    }

    public List<Integer> getLow() {
        if (low == null)
            low = new ArrayList<>();

        return low;
    }

    public void setLow(List<Integer> low) {
        this.low = low;
    }

    public List<Integer> getHigh() {
        if (high == null)
            high = new ArrayList<>();

        return high;
    }

    public void setHigh(List<Integer> high) {
        this.high = high;
    }

    public Envelope toEnvelope() {
        Envelope envelope = new Envelope();
        if (low != null && high != null && !low.isEmpty() && low.size() == high.size()) {
            envelope.include(low.stream().map(Double::valueOf).collect(Collectors.toList()));
            envelope.include(high.stream().map(Double::valueOf).collect(Collectors.toList()));
        }

        return envelope;
    }
}
