/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.complexes;

import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class GeometricComplexProperty extends GeometryProperty<AbstractGeometry> {

    public GeometricComplexProperty() {
    }

    public GeometricComplexProperty(AbstractGeometry object) {
        setInlineObject(object);
    }

    public GeometricComplexProperty(String href) {
        super(href);
    }

    @Override
    public void setInlineObject(AbstractGeometry object) {
        if (isValidObject(object)) {
            super.setInlineObject(object);
        }
    }

    @Override
    public void setReferencedObject(AbstractGeometry object) {
        if (isValidObject(object)) {
            super.setReferencedObject(object);
        }
    }

    public boolean isValidObject(AbstractGeometry object) {
        return object instanceof GeometricComplex
                || object instanceof CompositeCurve
                || object instanceof CompositeSurface
                || object instanceof CompositeSolid;
    }

    public GeometricComplex getGeometricComplex() {
        return isSetGeometricComplex() ? (GeometricComplex) getObject() : null;
    }

    public boolean isSetGeometricComplex() {
        return getObject() instanceof GeometricComplex;
    }

    public CompositeCurve getCompositeCurve() {
        return isSetCompositeCurve() ? (CompositeCurve) getObject() : null;
    }

    public boolean isSetCompositeCurve() {
        return getObject() instanceof CompositeCurve;
    }

    public CompositeSurface getCompositeSurface() {
        return isSetCompositeSurface() ? (CompositeSurface) getObject() : null;
    }

    public boolean isSetCompositeSurface() {
        return getObject() instanceof CompositeSurface;
    }

    public CompositeSolid getCompositeSolid() {
        return isSetCompositeSolid() ? (CompositeSolid) getObject() : null;
    }

    public boolean isSetCompositeSolid() {
        return getObject() instanceof CompositeSolid;
    }
}
