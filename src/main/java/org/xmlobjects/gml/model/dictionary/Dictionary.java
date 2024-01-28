/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2024 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
