package practice.domain;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        i = vec2d.iterator();
        j = null;
    }

    @Override
    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return j.next();
    }

    @Override
    public void remove() {

    }
}
