package practice.domain;

public class Tuple implements Comparable<Tuple> {

    public int x;
    public int y;
    public int val;

    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}
