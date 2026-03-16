/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry;

import java.util.List;

public interface SRSInformation {
    List<String> getAxisLabels();

    boolean isSetAxisLabels();

    void setAxisLabels(List<String> axisLabels);

    List<String> getUomLabels();

    boolean isSetUomLabels();

    void setUomLabels(List<String> uomLabels);
}
