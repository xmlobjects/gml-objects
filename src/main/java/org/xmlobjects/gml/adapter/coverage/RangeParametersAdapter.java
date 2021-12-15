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
