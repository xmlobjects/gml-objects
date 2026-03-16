/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.util.id;

@FunctionalInterface
public interface IdCreator {
    String createId();
}
