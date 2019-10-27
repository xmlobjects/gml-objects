package org.xmlobjects.gml.util.copy;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.Map;

public class ChildListCloner extends CollectionCloner<ChildList> {

    ChildListCloner() {
    }

    @Override
    public ChildList copy(ChildList src, ChildList dest, Map<Object, Object> clones, boolean shallowCopy, CopyBuilder builder) throws Exception {
        if (dest == null) {
            GMLObject parent = deepCopy(src.getParent(), builder);
            dest = new ChildList(parent);
        }

        return super.copy(src, dest, clones, shallowCopy, builder);
    }
}
