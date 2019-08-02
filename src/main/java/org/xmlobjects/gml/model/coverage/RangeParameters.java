package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;
import org.xmlobjects.gml.model.common.GenericElement;

public class RangeParameters extends AbstractProperty<GMLObject> {
    private GenericElement genericElement;

    public RangeParameters() {
    }

    public RangeParameters(GMLObject object) {
        super(object);
    }

    public RangeParameters(String href) {
        super(href);
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    public GenericElement getGenericElement() {
        return genericElement;
    }

    public boolean isSetGenericElement() {
        return genericElement != null;
    }

    public void setGenericElement(GenericElement genericElement) {
        this.genericElement = asChild(genericElement);
    }

    @Override
    public Class<GMLObject> getTargetType() {
        return GMLObject.class;
    }
}
