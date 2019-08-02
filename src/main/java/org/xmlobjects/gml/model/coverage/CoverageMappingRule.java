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
