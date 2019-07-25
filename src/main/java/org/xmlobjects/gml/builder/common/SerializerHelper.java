package org.xmlobjects.gml.builder.common;

import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.xml.Namespaces;

public class SerializerHelper {

    public static String getTargetNamespace(Namespaces namespaces) {
        return namespaces.contains(GMLConstants.GML_3_1_NAMESPACE_URI) ?
                GMLConstants.GML_3_1_NAMESPACE_URI : GMLConstants.GML_3_2_NAMESPACE_URI;
    }
}
