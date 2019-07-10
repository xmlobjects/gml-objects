package org.xmlobjects.gml.model.common;

import java.util.function.Consumer;

public class PatternValidator {

    public static boolean isValidName(String value) {
        return value != null && value.matches("[_:A-Za-z][-_:.A-Za-z0-9]*");
    }

    public static void ifValidName(String value, Consumer<String> action) {
        if (isValidName(value))
            action.accept(value);
    }

    public static boolean isValidUomSymbol(String value) {
        return value != null && value.matches("[^: \\n\\r\\t]+");
    }

    public static void ifValidUomSymbol(String value, Consumer<String> action) {
        if (isValidUomSymbol(value))
            action.accept(value);
    }

    public static boolean isValidUomURI(String value) {
        return value != null && value.matches("([a-zA-Z][a-zA-Z0-9\\-+.]*:|\\.\\./|\\./|#).*");
    }

    public static void ifValidUomURI(String value, Consumer<String> action) {
        if (isValidUomURI(value))
            action.accept(value);
    }

    public static boolean isValidUomIdentifier(String value) {
        return isValidUomSymbol(value) || isValidUomURI(value);
    }

    public static void ifValidUomIdentifier(String value, Consumer<String> action) {
        if (isValidUomIdentifier(value))
            action.accept(value);
    }
}
