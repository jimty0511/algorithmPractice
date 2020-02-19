package practice.lintcode;

import java.util.HashMap;
import java.util.Map;

// 1409. Matrix Finding Number
public class MatrixFindingNumber {
    /**
     * @param mat: The matrix
     * @return: The answer
     */
    public int findingNumber(int[][] mat) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (map.containsKey(mat[i][j])) {
                    if (map.get(mat[i][j]) == i - 1)
                        map.put(mat[i][j], i);
                } else {
                    if (i == 0)
                        map.put(mat[i][j], 0);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == mat.length - 1)
                ans = Math.min(ans, e.getKey());
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int findingNumberTwo(int[][] mat) {
        boolean[] exist = new boolean[100001];
        for (int j = 0; j < mat[0].length; j++)
            exist[mat[0][j]] = true;
        for (int i = 1; i < mat.length; i++) {
            boolean[] next = new boolean[100001];
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0)
                    next[mat[0][j]] = true;
                else if (exist[mat[i][j]]) {
                    next[mat[i][j]] = true;
                }
            }
            exist = next;
        }
        for (int i = 0; i < exist.length; i++) {
            if (exist[i])
                return i;
        }
        return -1;
    }
}
