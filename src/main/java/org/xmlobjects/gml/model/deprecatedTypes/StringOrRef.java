package org.xmlobjects.gml.model.deprecatedTypes;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.xlink.ActuateType;
import org.xmlobjects.gml.model.xlink.ShowType;

public class StringOrRef extends GMLObject implements AssociationAttributes {
    private String value;
    private String href;
    private String role;
    private String arcRole;
    private String title;
    private ShowType show;
    private ActuateType actuate;
    private String nilReason;
    private String remoteSchema;

    public StringOrRef() {
    }

    public StringOrRef(String value) {
        this.value = value;
    }

    public static StringOrRef ofReference(String href) {
        StringOrRef stringOrRef = new StringOrRef();
        stringOrRef.setHref(href);
        return stringOrRef;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public final String getType() {
        return "simple";
    }

    @Override
    public String getHref() {
        return href;
    }

    @Override
    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getArcRole() {
        return arcRole;
    }

    @Override
    public void setArcRole(String arcRole) {
        this.arcRole = arcRole;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public ShowType getShow() {
        return show;
    }

    @Override
    public void setShow(ShowType show) {
        this.show = show;
    }

    @Override
    public ActuateType getActuate() {
        return actuate;
    }

    @Override
    public void setActuate(ActuateType actuate) {
        this.actuate = actuate;
    }

    @Override
    public String getNilReason() {
        return nilReason;
    }

    @Override
    public void setNilReason(String nilReason) {
        this.nilReason = nilReason;
    }

    @Override
    public String getRemoteSchema() {
        return remoteSchema;
    }

    @Override
    public void setRemoteSchema(String remoteSchema) {
        this.remoteSchema = remoteSchema;
    }
}
