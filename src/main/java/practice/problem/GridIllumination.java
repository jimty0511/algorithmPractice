package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 1001. Grid Illumination
public class GridIllumination {

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 0}};

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diagonal = new HashMap<>();
        Map<Integer, Integer> antiDiag = new HashMap<>();
        Map<Integer, Boolean> onOff = new HashMap<>();
        for (int[] l : lamps) {
            int x = l[0], y = l[1];
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            diagonal.put(x + y, diagonal.getOrDefault(x + y, 0) + 1);
            antiDiag.put(x - y, antiDiag.getOrDefault(x - y, 0) + 1);
            onOff.put(N * x + y, true);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            ans[i] = (row.getOrDefault(x, 0) > 0 ||
                    col.getOrDefault(y, 0) > 0 ||
                    diagonal.getOrDefault(x + y, 0) > 0 ||
                    antiDiag.getOrDefault(x - y, 0) > 0) ? 1 : 0;
            for (int[] d : dirs) {
                int xx = x + d[0], yy = y + d[1];
                if (onOff.containsKey(N * xx + yy) && onOff.get(N * xx + yy)) {
                    row.put(xx, row.getOrDefault(xx, 1) - 1);
                    col.put(yy, col.getOrDefault(yy, 1) - 1);
                    diagonal.put(xx + yy, diagonal.getOrDefault(xx + yy, 1) - 1);
                    antiDiag.put(xx - yy, antiDiag.getOrDefault(xx - yy, 1) - 1);
                    onOff.put(N * xx + yy, false);
                }
            }
        }
        return ans;
    }
}
