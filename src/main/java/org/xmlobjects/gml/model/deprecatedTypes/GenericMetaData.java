package org.xmlobjects.gml.model.deprecatedTypes;

public class GenericMetaData extends AbstractMetaData {
    private String anyContent;

    public GenericMetaData() {
    }

    public GenericMetaData(String anyContent) {
        this.anyContent = anyContent;
    }

    public String getAnyContent() {
        return anyContent;
    }

    public void setAnyContent(String anyContent) {
        this.anyContent = anyContent;
    }
}
