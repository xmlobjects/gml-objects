package org.citygml4j.gmlobjects.model.deprecatedTypes;

import org.citygml4j.gmlobjects.model.base.AssociationAttributes;
import org.citygml4j.gmlobjects.model.basicTypes.NilReason;
import org.citygml4j.gmlobjects.model.common.ModelObject;
import org.citygml4j.gmlobjects.model.xlink.ActuateType;
import org.citygml4j.gmlobjects.model.xlink.ShowType;

public class StringOrRef extends ModelObject implements AssociationAttributes {
    private String value;
    private String href;
    private String role;
    private String arcRole;
    private String title;
    private ShowType show;
    private ActuateType actuate;
    private NilReason nilReason;
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
        href = null;
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
        value = null;
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
    public NilReason getNilReason() {
        return nilReason;
    }

    @Override
    public void setNilReason(NilReason nilReason) {
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
