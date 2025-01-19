/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2025 Claus Nagel <claus.nagel@gmail.com>
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
