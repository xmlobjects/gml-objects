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

package org.xmlobjects.gml.util.reference;

import org.xmlobjects.gml.visitor.Visitable;
import org.xmlobjects.model.Child;

import java.util.Map;

public interface ReferenceResolver {
    Child resolveReference(String reference, Visitable scope);
    <T extends Child> T resolveReference(String reference, Visitable scope, Class<T> type);
    void resolveReferences(Visitable scope);
    Map<String, ? extends Child> getObjectsById(Visitable scope);
    <T extends Child> Map<String, T> getObjectsById(Visitable scope, Class<T> type);
}