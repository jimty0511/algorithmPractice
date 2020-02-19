package practice.lintcode;

// 704. Bulb Switcher II
public class BulbSwitcherII {
    /**
     * @param n: number of lights
     * @param m: number of operations
     * @return: the number of status
     */
    public int flipLights(int n, int m) {
        // write your code here
        if (m == 1) {
            if (n == 2)
                return 3;
            return Math.min(4, 1 << n);
        }
        if (m == 2)
            return Math.min(7, 1 << n);
        return Math.min(8, 1 << Math.min(m, n));
    }
}
