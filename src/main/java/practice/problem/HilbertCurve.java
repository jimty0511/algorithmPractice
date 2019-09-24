package practice.problem;

public class HilbertCurve {
    public int hilbertCurve(int x, int y, int iter) {
        if (iter == 0)
            return 1;
        int num = 1 << (2 * (iter - 1));
        int len = 1 << (iter - 1);
        if (x >= len && y >= len) { // right-upper
            return 2 * num + hilbertCurve(x - len, y - len, iter - 1);
        } else if (x < len && y >= len) { // left-upper
            return num + hilbertCurve(x, y - len, iter - 1);
        } else if (x < len && y < len) { // left-bottom
            return hilbertCurve(y, x, iter - 1);
        } else { // right-bottom
            return 3 * num + hilbertCurve(len - y - 1, 2 * len - x - 1, iter - 1);
        }
    }
}