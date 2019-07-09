package org.citygml4j.gmlobjects.model.deprecatedTypes;

import org.citygml4j.gmlobjects.model.base.Association;

public class MetaDataProperty<T extends AbstractMetaData> extends Association<T> {
    private String about;

    public MetaDataProperty() {
    }

    public MetaDataProperty(T object) {
        super(object);
    }

    public MetaDataProperty(String href) {
        super(href);
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
