package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.model.common.LocalProperties;
import org.xmlobjects.gml.model.deprecated.MetaDataProperty;
import org.xmlobjects.gml.model.deprecated.StringOrRef;
import org.xmlobjects.model.ChildList;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGML extends GMLObject implements StandardObjectProperties {
    private String id;
    private List<MetaDataProperty<?>> metaDataProperties;
    private StringOrRef description;
    private Reference descriptionReference;
    private CodeWithAuthority identifier;
    private List<Code> names;
    private LocalProperties localProperties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public List<MetaDataProperty<?>> getMetaDataProperties() {
        if (metaDataProperties == null)
            metaDataProperties = new ChildList<>(this);

        return metaDataProperties;
    }

    @Override
    public void setMetaDataProperties(List<MetaDataProperty<?>> metaDataProperties) {
        this.metaDataProperties = asChild(metaDataProperties);
    }

    @Override
    public StringOrRef getDescription() {
        return description;
    }

    @Override
    public void setDescription(StringOrRef description) {
        this.description = asChild(description);
    }

    @Override
    public Reference getDescriptionReference() {
        return descriptionReference;
    }

    @Override
    public void setDescriptionReference(Reference descriptionReference) {
        this.descriptionReference = asChild(descriptionReference);
    }

    @Override
    public CodeWithAuthority getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(CodeWithAuthority identifier) {
        this.identifier = asChild(identifier);
    }

    @Override
    public List<Code> getNames() {
        if (names == null)
            names = asChild(new ArrayList<>());

        return names;
    }

    @Override
    public void setNames(List<Code> names) {
        this.names = asChild(names);
    }

    public LocalProperties getLocalProperties() {
        if (localProperties == null)
            localProperties = new LocalProperties();

        return localProperties;
    }
}
