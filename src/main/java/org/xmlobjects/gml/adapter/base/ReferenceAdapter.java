/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.base;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.base.Reference;

import javax.xml.namespace.QName;

public class ReferenceAdapter extends AbstractReferenceAdapter<Reference> {

    @Override
    public Reference createObject(QName name, Object parent) throws ObjectBuildException {
        return new Reference();
    }
}
