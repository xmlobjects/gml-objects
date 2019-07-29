package org.xmlobjects.gml.model.deprecated;

import org.xmlobjects.gml.model.base.AbstractProperty;
import org.xmlobjects.gml.model.common.GenericElement;

public class MetaDataProperty<T extends AbstractMetaData> extends AbstractProperty<T> {
    private GenericElement genericElement;
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

    public GenericElement getGenericElement() {
        return genericElement;
    }

    public boolean isSetGenericElement() {
        return genericElement != null;
    }

    public void setGenericElement(GenericElement genericElement) {
        this.genericElement = asChild(genericElement);
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
