/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.MultiPointDomain;

import javax.xml.namespace.QName;

public class MultiPointDomainAdapter extends AbstractPropertyAdapter<MultiPointDomain> {

    @Override
    public MultiPointDomain createObject(QName name, Object parent) throws ObjectBuildException {
        return new MultiPointDomain();
    }
}
