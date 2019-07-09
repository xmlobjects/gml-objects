package org.xmlobjects.gml.model.common;

import org.xmlobjects.gml.model.GMLObject;

import java.util.ArrayList;
import java.util.Collection;

public class ChildList<T extends GMLObject> extends ArrayList<T> {
    private final GMLObject parent;

    public ChildList(GMLObject parent) {
        this.parent = parent;
    }

    public ChildList(Collection<? extends T> c, GMLObject parent) {
        super(c);
        this.parent = parent;
        setParent(c);
    }

    public ChildList(int initialCapacity, GMLObject parent) {
        super(initialCapacity);
        this.parent = parent;
    }

    @Override
    public void add(int index, T element) {
        setParent(element);
        super.add(index, element);
    }

    @Override
    public boolean add(T o) {
        setParent(o);
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        setParent(c);
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        setParent(c);
        return super.addAll(index, c);
    }

    private void setParent(T child) {
        if (child != null)
            child.setParent(parent);
    }

    private void setParent(Collection<? extends T> c) {
        for (T child : c) {
            if (child != null)
                child.setParent(parent);
        }
    }
}
