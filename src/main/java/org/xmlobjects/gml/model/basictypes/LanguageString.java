package org.xmlobjects.gml.model.basictypes;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.util.XMLPatterns;

public class LanguageString extends GMLObject {
    private String value;
    private String language;

    public LanguageString() {
    }

    public LanguageString(String value) {
        this.value = value;
    }

    public LanguageString(String value, String language) {
        this(value);
        setLanguage(language);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = XMLPatterns.LANGUAGE.matcher(language).matches() ? language : null;
    }
}
