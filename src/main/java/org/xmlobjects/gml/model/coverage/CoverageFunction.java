/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2021 Claus Nagel <claus.nagel@gmail.com>
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
