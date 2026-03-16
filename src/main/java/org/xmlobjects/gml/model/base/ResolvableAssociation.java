/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.util.reference.ReferenceResolver;
import org.xmlobjects.gml.visitor.Visitable;
import org.xmlobjects.model.Child;

import java.util.Collection;

public interface ResolvableAssociation<T extends Child> extends Child, AssociationAttributes {
    boolean isSetReferencedObject();

    void setReferencedObject(T object);

    void setReferencedObject(T object, boolean updateReference);

    void setReferencedObjectIfValid(Child object);

    void setReferencedObjectIfValid(Child object, boolean updateReference);

    Class<T> getTargetType();

    default T resolveReference(ReferenceResolver resolver, Collection<Visitable> scopes) {
        return resolver.resolveReference(getHref(), getTargetType(), scopes);
    }

    default T resolveReference(ReferenceResolver resolver, Visitable... scopes) {
        return resolver.resolveReference(getHref(), getTargetType(), scopes);
    }

    default T resolveReference(ReferenceResolver resolver) {
        Visitable scope = null;
        Child parent = this;
        do {
            if (parent instanceof Visitable visitable) {
                scope = visitable;
            }
        } while ((parent = parent.getParent()) != null);

        return scope != null ? resolveReference(resolver, scope) : null;
    }
}
