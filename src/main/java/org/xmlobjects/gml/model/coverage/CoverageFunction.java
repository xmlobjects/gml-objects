package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.GMLObject;

public class CoverageFunction extends GMLObject {
    private CoverageMappingRule mappingRule;
    private GridFunction gridFunction;

    public CoverageFunction() {
    }

    public CoverageFunction(CoverageMappingRule mappingRule) {
        setMappingRule(mappingRule);
    }

    public CoverageFunction(GridFunction gridFunction) {
        setGridFunction(gridFunction);
    }

    public CoverageMappingRule getMappingRule() {
        return mappingRule;
    }

    public boolean isSetMappingRule() {
        return mappingRule != null;
    }

    public void setMappingRule(CoverageMappingRule mappingRule) {
        this.mappingRule = asChild(mappingRule);
        gridFunction = null;
    }

    public GridFunction getGridFunction() {
        return gridFunction;
    }

    public boolean isSetGridFunction() {
        return gridFunction != null;
    }

    public void setGridFunction(GridFunction gridFunction) {
        this.gridFunction = asChild(gridFunction);
        mappingRule = null;
    }
}
