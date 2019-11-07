package org.xmlobjects.gml.model.temporal;

public class TimeCoordinate implements TimePositionValue<Double> {
    private final Double coordinate;

    public TimeCoordinate(Double coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public Double getValue() {
        return coordinate;
    }
}
