package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.GMLObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Coordinates extends GMLObject implements PosListProvider {
    private String value;
    private String decimal;
    private String cs;
    private String ts;

    public Coordinates() {
    }

    public Coordinates(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDecimal() {
        return decimal != null ? decimal : ".";
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }

    public String getCoordinateSeparator() {
        return cs != null ? cs : ",";
    }

    public void setCoordinateSeparator(String cs) {
        this.cs = cs;
    }

    public String getTupleSeparator() {
        return ts != null ? ts : " ";
    }

    public void setTupleSeparator(String ts) {
        this.ts = ts;
    }

    @Override
    public List<Double> toPosList3D() {
        Double[] posList = null;
        boolean isValid = true;

        if (value != null) {
            String decimalPattern = Pattern.quote(getDecimal()) + "+";
            String csPattern = Pattern.quote(getCoordinateSeparator()) + "+";
            String tsPattern = Pattern.quote(getTupleSeparator()) + "+";

            String content = value.trim().replaceAll("\\R+", getTupleSeparator());
            String[] tuples = content.split(tsPattern);
            posList = new Double[tuples.length * 3];
            int i = 0;

            for (int j = 0; j < tuples.length && isValid; j++) {
                String[] coords = tuples[j].split(csPattern);
                for (int k = 0; k < 3 && isValid; k++) {
                    if (k < coords.length) {
                        try {
                            posList[i++] = Double.parseDouble(coords[k].replaceAll(decimalPattern, "."));
                        } catch (Throwable e) {
                            isValid = false;
                        }
                    } else
                        posList[i++] = 0d;
                }
            }
        }

        return posList != null && isValid ? Arrays.asList(posList) : Collections.emptyList();
    }
}
