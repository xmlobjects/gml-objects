/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.RectifiedGridDomain;

import javax.xml.namespace.QName;

public class RectifiedGridDomainAdapter extends AbstractPropertyAdapter<RectifiedGridDomain> {

    @Override
    public RectifiedGridDomain createObject(QName name, Object parent) throws ObjectBuildException {
        return new RectifiedGridDomain();
    }
}
