/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.deprecated;

import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class LocationProperty extends GeometryProperty<AbstractGeometry> {
    private Code locationKeyWord;
    private StringOrRef locationString;
    private NilReason nullReason;

    public LocationProperty() {
    }

    public LocationProperty(AbstractGeometry geometry) {
        super(geometry);
    }

    public LocationProperty(Code locationKeyWord) {
        setLocationKeyWord(locationKeyWord);
    }

    public LocationProperty(StringOrRef locationString) {
        setLocationString(locationString);
    }

    public LocationProperty(String href) {
        super(href);
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    @Override
    public void setInlineObject(AbstractGeometry geometry) {
        super.setInlineObject(geometry);
        locationKeyWord = null;
        locationString = null;
        nullReason = null;
    }

    @Override
    public void setReferencedObject(AbstractGeometry object) {
        super.setReferencedObject(object);
        locationKeyWord = null;
        locationString = null;
        nullReason = null;
    }

    public Code getLocationKeyWord() {
        return locationKeyWord;
    }

    public boolean isSetLocationKeyWord() {
        return locationKeyWord != null;
    }

    public void setLocationKeyWord(Code locationKeyWord) {
        this.locationKeyWord = asChild(locationKeyWord);
        super.setInlineObject(null);
        setReference(null);
        locationString = null;
        nullReason = null;
    }

    public StringOrRef getLocationString() {
        return locationString;
    }

    public boolean isSetLocationString() {
        return locationString != null;
    }

    public void setLocationString(StringOrRef locationString) {
        this.locationString = asChild(locationString);
        super.setInlineObject(null);
        setReference(null);
        locationKeyWord = null;
        nullReason = null;
    }

    public NilReason getNull() {
        return nullReason;
    }

    public boolean isSetNull() {
        return nullReason != null;
    }

    public void setNull(NilReason nullReason) {
        this.nullReason = asChild(nullReason);
        super.setInlineObject(null);
        setReference(null);
        locationKeyWord = null;
        locationString = null;
    }
}
