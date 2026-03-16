/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.coverage.RangeParameters;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.*;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class RangeParametersAdapter extends AbstractPropertyAdapter<RangeParameters> {

    @Override
    public RangeParameters createObject(QName name, Object parent) throws ObjectBuildException {
        return new RangeParameters();
    }

    @Override
    public void buildChildObject(RangeParameters object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuildResult<GMLObject> result = reader.getObjectOrDOMElement(object.getTargetType());
        if (result.isSetObject())
            object.setInlineObject(result.getObject());
        else if (result.isSetDOMElement())
            object.setGenericElement(GenericElement.of(result.getDOMElement()));
    }

    @Override
    public void writeChildElements(RangeParameters object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetInlineObject())
            writer.writeObject(object.getObject(), namespaces);
        else if (object.isSetGenericElement())
            writer.writeDOMElement(object.getGenericElement().getContent());
    }
}
