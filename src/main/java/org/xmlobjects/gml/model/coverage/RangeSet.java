/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2021 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.valueobjects.AbstractScalarValueList;
import org.xmlobjects.gml.model.valueobjects.ValueArray;
import org.xmlobjects.model.ChildList;

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
