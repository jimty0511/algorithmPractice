package practice.domain;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    Integer next = null;
    Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
        if (this.iter.hasNext())
            this.next = this.iter.next();
    }

    public Integer peek() {
        return next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        Integer res = next;
        next = this.iter.hasNext() ? this.iter.next() : null;
        return res;
    }
}
