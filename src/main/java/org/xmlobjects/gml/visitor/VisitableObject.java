/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.visitor;

public interface VisitableObject extends Visitable {
    void accept(ObjectVisitor visitor);
}
