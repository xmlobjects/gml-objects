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
