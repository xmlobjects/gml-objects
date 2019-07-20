package org.xmlobjects.gml.util;

import java.util.regex.Pattern;

public class GMLPatterns {
    public static final Pattern UOM_SYMBOL = Pattern.compile("[^: \\n\\r\\t]+");
    public static final Pattern UOM_URI = Pattern.compile("([a-zA-Z][a-zA-Z0-9\\-+.]*:|\\.\\./|\\./|#).*");
    public static final Pattern OTHER_VALUE = Pattern.compile("other:\\w{2,}");
}
