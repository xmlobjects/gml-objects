/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.dictionary;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Dictionary extends Definition implements AggregationAttributes {
    private List<DefinitionProperty> definitions;
    private AggregationType aggregationType;

    public Dictionary() {
    }

    public Dictionary(CodeWithAuthority identifier) {
        super(identifier);
    }

    public Dictionary(CodeWithAuthority identifier, List<DefinitionProperty> definitions) {
        this(identifier);
        setDefinitions(definitions);
    }

    public List<DefinitionProperty> getDefinitions() {
        if (definitions == null) {
            definitions = new ChildList<>(this);
        }

        return definitions;
    }

    public boolean isSetDefinitions() {
        return definitions != null && !definitions.isEmpty();
    }

    public void setDefinitions(List<DefinitionProperty> definitions) {
        this.definitions = asChild(definitions);
    }

    @Override
    public AggregationType getAggregationType() {
        return aggregationType;
    }

    @Override
    public void setAggregationType(AggregationType aggregationType) {
        this.aggregationType = aggregationType;
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
