/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.util.reference.ReferenceResolver;
import org.xmlobjects.gml.visitor.Visitable;
import org.xmlobjects.model.Child;

public interface ResolvableAssociation<T extends Child> extends Child, AssociationAttributes {
    boolean isSetReferencedObject();
    void setReferencedObject(T object);
    void setReferencedObject(T object, boolean updateReference);
    void setReferencedObjectIfValid(Child object);
    void setReferencedObjectIfValid(Child object, boolean updateReference);
    Class<T> getTargetType();

    default T resolveReference(ReferenceResolver resolver, Visitable scope) {
        return resolver.resolveReference(getHref(), scope, getTargetType());
    }

    default T resolveReference(ReferenceResolver resolver) {
        Visitable scope = null;
        Child parent = this;
        do {
            if (parent instanceof Visitable) {
                scope = (Visitable) parent;
            }
        } while ((parent = parent.getParent()) != null);

        return scope != null ? resolveReference(resolver, scope) : null;
    }
}
