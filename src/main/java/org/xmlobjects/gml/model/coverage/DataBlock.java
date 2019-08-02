package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Coordinates;
import org.xmlobjects.gml.model.basictypes.DoubleOrNilReasonList;

public class DataBlock extends GMLObject {
    private RangeParameters rangeParameters;
    private Coordinates tupleList;
    private DoubleOrNilReasonList doubleOrNilReasonTupleList;

    public DataBlock() {
    }

    public DataBlock(RangeParameters rangeParameters) {
        setRangeParameters(rangeParameters);
    }

    public RangeParameters getRangeParameters() {
        return rangeParameters;
    }

    public void setRangeParameters(RangeParameters rangeParameters) {
        this.rangeParameters = asChild(rangeParameters);
    }

    public Coordinates getTupleList() {
        return tupleList;
    }

    public boolean isSetTupleList() {
        return tupleList != null;
    }

    public void setTupleList(Coordinates tupleList) {
        this.tupleList = asChild(tupleList);
        doubleOrNilReasonTupleList = null;
    }

    public DoubleOrNilReasonList getDoubleOrNilReasonTupleList() {
        return doubleOrNilReasonTupleList;
    }

    public boolean isSetDoubleOrNilReasonTupleList() {
        return doubleOrNilReasonTupleList != null;
    }

    public void setDoubleOrNilReasonTupleList(DoubleOrNilReasonList doubleOrNilReasonTupleList) {
        this.doubleOrNilReasonTupleList = asChild(doubleOrNilReasonTupleList);
        tupleList = null;
    }
}
