package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.basicTypes.Code;
import org.xmlobjects.gml.model.basicTypes.CodeWithAuthority;
import org.xmlobjects.gml.model.deprecatedTypes.MetaDataProperty;
import org.xmlobjects.gml.model.deprecatedTypes.StringOrRef;

import java.util.List;

public interface StandardObjectProperties {
    List<MetaDataProperty> getMetaDataProperties();
    void setMetaDataProperties(List<MetaDataProperty> metaDataProperties);
    StringOrRef getDescription();
    void setDescription(StringOrRef description);
    Reference getDescriptionReference();
    void setDescriptionReference(Reference descriptionReference);
    CodeWithAuthority getIdentifier();
    void setIdentifier(CodeWithAuthority identifier);
    List<Code> getNames();
    void setNames(List<Code> names);
}
