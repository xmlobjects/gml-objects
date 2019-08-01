package org.xmlobjects.gml.model.common;

import org.xmlobjects.gml.model.GMLObject;

import java.util.ArrayList;
import java.util.Collection;

public class ChildList<T extends Child> extends ArrayList<T> {
    private GMLObject parent;

    public ChildList(GMLObject parent) {
        this.parent = parent;
    }

    public ChildList(Collection<? extends T> c, GMLObject parent) {
        super(c);
        this.parent = parent;
        applyParent(c);
    }

    public ChildList(int initialCapacity, GMLObject parent) {
        super(initialCapacity);
        this.parent = parent;
    }

    public GMLObject getParent() {
        return parent;
    }

    public void setParent(GMLObject parent) {
        this.parent = parent;
        applyParent(this);
    }

    @Override
    public void add(int index, T element) {
        applyParent(element);
        super.add(index, element);
    }

    @Override
    public boolean add(T o) {
        applyParent(o);
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        applyParent(c);
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        applyParent(c);
        return super.addAll(index, c);
    }

    private void applyParent(T child) {
        if (child != null)
            child.setParent(parent);
    }

    private void applyParent(Collection<? extends T> c) {
        for (T child : c) {
            if (child != null)
                child.setParent(parent);
        }
    }
}
