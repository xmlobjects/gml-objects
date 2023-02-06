/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2023 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.basictypes.Sign;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

import java.util.Collections;
import java.util.List;

public class OrientableCurve extends AbstractCurve {
    private CurveProperty baseCurve;
    private Sign orientation;

    public OrientableCurve() {
    }

    public OrientableCurve(CurveProperty baseCurve) {
        setBaseCurve(baseCurve);
    }

    public OrientableCurve(AbstractCurve baseCurve) {
        this(new CurveProperty(baseCurve));
    }

    public CurveProperty getBaseCurve() {
        return baseCurve;
    }

    public void setBaseCurve(CurveProperty baseCurve) {
        this.baseCurve = asChild(baseCurve);
    }

    public Sign getOrientation() {
        return orientation != null ? orientation : Sign.PLUS;
    }

    public void setOrientation(Sign orientation) {
        this.orientation = orientation;
    }

    @Override
    public List<Double> toCoordinateList3D() {
        return baseCurve != null && baseCurve.getObject() != null ?
                baseCurve.getObject().toCoordinateList3D(getOrientation() == Sign.MINUS) :
                Collections.emptyList();
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
