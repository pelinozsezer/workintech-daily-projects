package org.example;

import java.util.ArrayList;
import java.util.Collections;

// Element
public class WorkintechList<E extends Comparable<E>> extends ArrayList<E> {



    public void sort() {
        Collections.sort(this);
    }

    @Override
    public boolean add(E e) {
        if (!this.contains(e)) {
            return super.add(e);
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = super.remove(o);
        if (removed) {
            this.sort();
        }
        return removed;
    }
}
