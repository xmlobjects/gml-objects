package org.xmlobjects.gml.model.deprecatedTypes;

import org.xmlobjects.gml.model.basicTypes.Code;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class LocationProperty extends GeometryProperty<AbstractGeometry> {
    private Code locationKeyWord;
    private StringOrRef locationString;
    private String nullReason;

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

    public static LocationProperty ofNull(String nullReason) {
        LocationProperty locationProperty = new LocationProperty();
        locationProperty.setNull(nullReason);
        return locationProperty;
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

    public String getNull() {
        return nullReason;
    }

    public boolean isSetNull() {
        return nullReason != null;
    }

    public void setNull(String nullReason) {
        this.nullReason = nullReason;
        super.setObject(null);
        locationKeyWord = null;
        locationString = null;
    }
}