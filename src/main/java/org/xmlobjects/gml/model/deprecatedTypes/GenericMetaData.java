package org.xmlobjects.gml.model.deprecatedTypes;

import org.w3c.dom.Element;

public class GenericMetaData extends AbstractMetaData {
    private Element content;

    public GenericMetaData() {
    }

    public GenericMetaData(Element content) {
        this.content = content;
    }

    public Element getContent() {
        return content;
    }

    public void setContent(Element content) {
        this.content = content;
    }
}
