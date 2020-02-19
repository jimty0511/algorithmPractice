package practice.lintcode;

import java.util.Iterator;
import java.util.List;

// 601. Flatten 2D Vector
public class Flatten2DVector implements Iterator<Integer> {

    int idx = 0, subIdx = 0;
    List<List<Integer>> vec;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        this.vec = vec2d;
        skip();
    }

    @Override
    public Integer next() {
        // Write your code here
        int val = vec.get(idx).get(subIdx);
        subIdx++;
        skip();
        return val;
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        return !(idx >= vec.size() || (idx == vec.size() - 1 && subIdx == vec.get(idx).size()));
    }

    @Override
    public void remove() {
    }

    private void skip() {
        while (idx < vec.size() && subIdx >= vec.get(idx).size()) {
            subIdx = 0;
            idx++;
        }
    }
}
