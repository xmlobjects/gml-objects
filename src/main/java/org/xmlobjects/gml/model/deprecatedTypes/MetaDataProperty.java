package org.xmlobjects.gml.model.deprecatedTypes;

import org.w3c.dom.Element;
import org.xmlobjects.gml.model.base.AbstractProperty;

public class MetaDataProperty<T extends AbstractMetaData> extends AbstractProperty<T> {
    private Element genericElement;
    private String about;

    public MetaDataProperty() {
    }

    public MetaDataProperty(T object) {
        super(object);
    }

    public MetaDataProperty(String href) {
        super(href);
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    public Element getGenericElement() {
        return genericElement;
    }

    public boolean isSetGenericElement() {
        return genericElement != null;
    }

    public void setGenericElement(Element genericElement) {
        this.genericElement = genericElement;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractMetaData.class;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
