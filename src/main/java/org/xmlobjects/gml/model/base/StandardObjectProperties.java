/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.model.deprecated.MetaDataProperty;
import org.xmlobjects.gml.model.deprecated.StringOrRef;

import java.util.List;

public interface StandardObjectProperties {
    List<MetaDataProperty<?>> getMetaDataProperties();

    boolean isSetMetaDataProperties();

    void setMetaDataProperties(List<MetaDataProperty<?>> metaDataProperties);

    StringOrRef getDescription();

    void setDescription(StringOrRef description);

    Reference getDescriptionReference();

    void setDescriptionReference(Reference descriptionReference);

    CodeWithAuthority getIdentifier();

    void setIdentifier(CodeWithAuthority identifier);

    List<Code> getNames();

    boolean isSetNames();

    void setNames(List<Code> names);
}
