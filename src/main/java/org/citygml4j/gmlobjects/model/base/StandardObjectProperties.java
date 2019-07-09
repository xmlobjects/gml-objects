package org.citygml4j.gmlobjects.model.base;

import org.citygml4j.gmlobjects.model.basicTypes.Code;
import org.citygml4j.gmlobjects.model.basicTypes.CodeWithAuthority;
import org.citygml4j.gmlobjects.model.deprecatedTypes.MetaDataProperty;
import org.citygml4j.gmlobjects.model.deprecatedTypes.StringOrRef;

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
