package org.xmlobjects.gml.model.geometry;

public interface SRSReference extends SRSInformation {
    String getSrsName();
    void setSrsName(String srsName);
    Integer getSrsDimension();
    void setSrsDimension(Integer srsDimension);
}
