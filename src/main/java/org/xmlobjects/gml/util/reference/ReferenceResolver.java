/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.util.reference;

import org.xmlobjects.gml.visitor.Visitable;
import org.xmlobjects.model.Child;

import java.util.Collection;
import java.util.Map;

public interface ReferenceResolver {
    Child resolveReference(String reference, Collection<? extends Visitable> scopes);

    Child resolveReference(String reference, Visitable... scopes);

    <T extends Child> T resolveReference(String reference, Class<T> type, Collection<? extends Visitable> scopes);

    <T extends Child> T resolveReference(String reference, Class<T> type, Visitable... scopes);

    void resolveReferences(Collection<? extends Visitable> scopes);

    void resolveReferences(Visitable... scopes);

    Map<String, ? extends Child> getObjectsById(Collection<? extends Visitable> scopes);

    Map<String, ? extends Child> getObjectsById(Visitable... scopes);

    <T extends Child> Map<String, T> getObjectsById(Class<T> type, Collection<? extends Visitable> scopes);

    <T extends Child> Map<String, T> getObjectsById(Class<T> type, Visitable... scopes);

    void removeResolvedReferences(Collection<? extends Visitable> scopes);

    void removeResolvedReferences(Visitable... scopes);
}
