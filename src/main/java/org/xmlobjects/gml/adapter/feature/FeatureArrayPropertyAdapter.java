/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.feature;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.feature.FeatureArrayProperty;

import javax.xml.namespace.QName;

public class FeatureArrayPropertyAdapter extends AbstractFeatureArrayPropertyAdapter<FeatureArrayProperty<?>> {

    @Override
    public FeatureArrayProperty<AbstractFeature> createObject(QName name, Object parent) throws ObjectBuildException {
        return new FeatureArrayProperty<>();
    }
}
