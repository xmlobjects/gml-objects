/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import java.io.Serializable;

public interface TimePositionValue<T> extends Serializable {
    T getValue();
}
