package org.xmlobjects.gml.model.basictypes;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.util.GMLPatterns;

import java.net.URI;
import java.net.URISyntaxException;

public class NilReason extends GMLObject {
    private String value;

    public NilReason() {
    }

    public NilReason(NilReasonEnumeration value) {
        setValue(value);
    }

    public NilReason(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(NilReasonEnumeration value) {
        this.value = value.toValue();
    }

    public void setValue(String value) {
        if (NilReasonEnumeration.fromValue(value) != null || GMLPatterns.OTHER_VALUE.matcher(value).matches())
            this.value = value;
        else {
            try {
                URI uri = new URI(value);
                this.value = uri.toString();
            } catch (URISyntaxException e) {
                //
            }
        }
    }
}
