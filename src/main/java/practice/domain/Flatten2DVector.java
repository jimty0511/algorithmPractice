package practice.domain;

// 251. Flatten 2D Vector
public class Flatten2DVector {

    int idx = 0;
    int subIdx = 0;
    int[][] v;

    public Flatten2DVector(int[][] v) {
        this.v = v;
        skip();
    }

    public int next() {
        int val = v[idx][subIdx];
        subIdx++;
        skip();
        return val;
    }

    private void skip() {
        while (idx < v.length && subIdx >= v[idx].length) {
            subIdx = 0;
            idx++;
        }
    }

    public boolean hasNext() {
        return !(idx >= v.length || (idx == v.length - 1 && subIdx == v[idx].length));
    }
}
