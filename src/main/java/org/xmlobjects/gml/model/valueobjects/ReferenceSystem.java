/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.valueobjects;

public interface ReferenceSystem {
    String getCodeSpace();

    void setCodeSpace(String codeSpace);

    String getUom();

    void setUom(String uom);
}
