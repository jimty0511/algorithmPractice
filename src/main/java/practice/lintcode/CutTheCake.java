package practice.lintcode;

import java.util.HashMap;
import java.util.Map;

// 1681. Cut the cake
public class CutTheCake {
    /**
     * @param n:  the length of the cake
     * @param m:  the width of the cake
     * @param k:  the number of the strewberries
     * @param mp: the position of the k strewberries
     * @return: the shortest cut length
     */
    public int getTheShortestCutLength(int n, int m, int k, int[][] mp) {
        // Write your code here.
        Map<String, Integer> map = new HashMap<>();
        return helper(mp, k, 1, 1, n, m, map);
    }

    private int helper(int[][] mp, int k, int x1, int y1, int x2, int y2, Map<String, Integer> map) {
        if (map.containsKey(x1 + "," + y1 + "," + x2 + "," + y2))
            return map.get(x1 + "," + y1 + "," + x2 + "," + y2);
        if (k == 1) {
            map.put(x1 + "," + y1 + "," + x2 + "," + y2, 0);
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = x1; i < x2; i++) {
            int cnt = 0;
            for (int[] m : mp) {
                if (m[0] <= i && m[0] >= x1 && m[0] <= x2 && m[1] >= y1 && m[1] <= y2) cnt++;
            }
            if (cnt > 0 && cnt < k) {
                min = Math.min(min, helper(mp, k - cnt, i + 1, y1, x2, y2, map) +
                        helper(mp, cnt, x1, y1, i, y2, map) + y2 - y1 + 1);
            }
        }
        for (int j = y1; j < y2; j++) {
            int cnt = 0;
            for (int[] m : mp) {
                if (m[1] <= j && m[0] >= x1 && m[0] <= x2 && m[1] >= y1 && m[1] <= y2) cnt++;
            }
            if (cnt > 0 && cnt < k) {
                min = Math.min(min, helper(mp, k - cnt, x1, j + 1, x2, y2, map) +
                        helper(mp, cnt, x1, y1, x2, j, map) + x2 - x1 + 1);
            }
        }
        map.put(x1 + "," + y1 + "," + x2 + "," + y2, min);
        return min;
    }
}
