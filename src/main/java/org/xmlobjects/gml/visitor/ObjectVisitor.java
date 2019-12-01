package org.xmlobjects.gml.visitor;

import org.xmlobjects.gml.model.temporal.TimeInstant;
import org.xmlobjects.gml.model.temporal.TimePeriod;
import org.xmlobjects.gml.model.valueobjects.CompositeValue;
import org.xmlobjects.gml.model.valueobjects.ValueArray;

public interface ObjectVisitor extends FeatureVisitor, GeometryVisitor {
    void visit(CompositeValue compositeValue);
    void visit(TimeInstant timeInstant);
    void visit(TimePeriod timePeriod);
    void visit(ValueArray valueArray);
}
