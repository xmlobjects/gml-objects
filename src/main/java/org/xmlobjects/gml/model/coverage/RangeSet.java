package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.valueobjects.AbstractScalarValueList;
import org.xmlobjects.gml.model.valueobjects.ValueArray;

import java.util.List;

public class RangeSet extends GMLObject {
    private List<ValueArray> valueArrays;
    private List<AbstractScalarValueList> scalarValueLists;
    private DataBlock dataBlock;
    private File file;

    public RangeSet() {
    }

    public static RangeSet ofValueArrays(List<ValueArray> valueArrays) {
        RangeSet rangeSet = new RangeSet();
        rangeSet.setValueArrays(valueArrays);
        return rangeSet;
    }

    public static RangeSet ofScalarValueList(List<AbstractScalarValueList> scalarValueLists) {
        RangeSet rangeSet = new RangeSet();
        rangeSet.setScalarValueLists(scalarValueLists);
        return rangeSet;
    }

    public static RangeSet ofDataBlock(DataBlock dataBlock) {
        RangeSet rangeSet = new RangeSet();
        rangeSet.setDataBlock(dataBlock);
        return rangeSet;
    }

    public static RangeSet ofFile(File file) {
        RangeSet rangeSet = new RangeSet();
        rangeSet.setFile(file);
        return rangeSet;
    }

    public List<ValueArray> getValueArrays() {
        if (valueArrays == null)
            valueArrays = new ChildList<>(this);

        return valueArrays;
    }

    public boolean isSetValueArrays() {
        return valueArrays != null && !valueArrays.isEmpty();
    }

    public void setValueArrays(List<ValueArray> valueArrays) {
        this.valueArrays = asChild(valueArrays);
        scalarValueLists = null;
        dataBlock = null;
        file = null;
    }

    public List<AbstractScalarValueList> getScalarValueLists() {
        if (scalarValueLists == null)
            scalarValueLists = new ChildList<>(this);

        return scalarValueLists;
    }

    public boolean isSetScalarValueLists() {
        return scalarValueLists != null && !scalarValueLists.isEmpty();
    }

    public void setScalarValueLists(List<AbstractScalarValueList> scalarValueLists) {
        this.scalarValueLists = asChild(scalarValueLists);
        valueArrays = null;
        dataBlock = null;
        file = null;
    }

    public DataBlock getDataBlock() {
        return dataBlock;
    }

    public boolean isSetDataBlock() {
        return dataBlock != null;
    }

    public void setDataBlock(DataBlock dataBlock) {
        this.dataBlock = asChild(dataBlock);
        valueArrays = null;
        scalarValueLists = null;
        file = null;
    }

    public File getFile() {
        return file;
    }

    public boolean isSetFile() {
        return file != null;
    }

    public void setFile(File file) {
        this.file = asChild(file);
        valueArrays = null;
        scalarValueLists = null;
        dataBlock = null;
    }
}
