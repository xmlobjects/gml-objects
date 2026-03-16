/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.geometry.aggregates.MultiSolid;

public class MultiSolidDomain extends AbstractDomainSet<MultiSolid> {

    public MultiSolidDomain() {
    }

    public MultiSolidDomain(MultiSolid object) {
        super(object);
    }

    public MultiSolidDomain(String href) {
        super(href);
    }

    @Override
    public Class<MultiSolid> getTargetType() {
        return MultiSolid.class;
    }
}
