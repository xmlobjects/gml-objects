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

package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.Reference;

public class CoverageMappingRule extends GMLObject {
    private String ruleDefinition;
    private Reference ruleReference;

    public CoverageMappingRule() {
    }

    public CoverageMappingRule(String ruleDefinition) {
        this.ruleDefinition = ruleDefinition;
    }

    public CoverageMappingRule(Reference ruleReference) {
        this.ruleReference = asChild(ruleReference);
    }

    public String getRuleDefinition() {
        return ruleDefinition;
    }

    public boolean isSetRuleDefinition() {
        return ruleDefinition != null;
    }

    public void setRuleDefinition(String ruleDefinition) {
        this.ruleDefinition = ruleDefinition;
        ruleReference = null;
    }

    public Reference getRuleReference() {
        return ruleReference;
    }

    public boolean isSetRuleReference() {
        return ruleReference != null;
    }

    public void setRuleReference(Reference ruleReference) {
        this.ruleReference = asChild(ruleReference);
        ruleDefinition = null;
    }
}
