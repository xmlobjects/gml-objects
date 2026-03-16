/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.util;

import org.xmlobjects.gml.converter.SimpleMultiPointConverter;
import org.xmlobjects.gml.converter.SimplePolygonConverter;
import org.xmlobjects.gml.converter.SimpleRectangleConverter;
import org.xmlobjects.gml.converter.SimpleTriangleConverter;

public class GMLConstants {
    public static final String GML_3_3_XBT_NAMESPACE = "http://www.opengis.net/gml/3.3/xbt";
    public static final String GML_3_3_XBT_SCHEMA_LOCATION = "http://schemas.opengis.net/gml/3.3/extdBaseTypes.xsd";
    public static final String GML_3_3_CE_NAMESPACE = "http://www.opengis.net/gml/3.3/ce";
    public static final String GML_3_3_CE_SCHEMA_LOCATION = "http://schemas.opengis.net/gml/3.3/geometryCompact.xsd";
    public static final String GML_3_2_NAMESPACE = "http://www.opengis.net/gml/3.2";
    public static final String GML_3_2_SCHEMA_LOCATION = "http://schemas.opengis.net/gml/3.2.1/gml.xsd";
    public static final String GML_3_1_NAMESPACE = "http://www.opengis.net/gml";
    public static final String GML_3_1_SCHEMA_LOCATION = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
    public static final String XLINK_NAMESPACE = "http://www.w3.org/1999/xlink";
    public static final String XLINK_SCHEMA_LOCATION = "https://www.w3.org/1999/xlink.xsd";

    public static final String SIMPLE_POLYGON_CONVERTER = SimplePolygonConverter.class.getName();
    public static final String SIMPLE_RECTANGLE_CONVERTER = SimpleRectangleConverter.class.getName();
    public static final String SIMPLE_TRIANGLE_CONVERTER = SimpleTriangleConverter.class.getName();
    public static final String SIMPLE_MULTI_POINT_CONVERTER = SimpleMultiPointConverter.class.getName();
}
