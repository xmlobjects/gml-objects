/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.deprecated;

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
