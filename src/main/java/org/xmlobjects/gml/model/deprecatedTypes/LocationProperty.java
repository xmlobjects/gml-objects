package org.xmlobjects.gml.model.deprecatedTypes;

import org.xmlobjects.gml.model.basicTypes.Code;
import org.xmlobjects.gml.model.basicTypes.NilReason;
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

    public LocationProperty(NilReason nullReason) {
        setNull(nullReason);
    }

    public LocationProperty(String href) {
        super(href);
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    @Override
    public void setObject(AbstractGeometry geometry) {
        super.setObject(geometry);
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
        super.setObject(null);
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
        super.setObject(null);
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
        super.setObject(null);
        locationKeyWord = null;
        locationString = null;
    }
}
