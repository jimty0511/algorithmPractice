package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 835. Image Overlap
public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        List<int[]> la = new ArrayList<>(), lb = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1)
                    la.add(new int[]{i, j});
                if (B[i][j] == 1)
                    lb.add(new int[]{i, j});
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int[] a : la) {
            for (int[] b : lb) {
                String s = (a[0] - b[0]) + " " + (a[1] - b[1]);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int max = 0;
        for (int count : map.values())
            max = Math.max(max, count);
        return max;
    }

    public int largestOverlapTwo(int[][] A, int[][] B) {
        int n = A.length;
        List<Integer> la = new ArrayList<>(), lb = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n * n; i++) {
            if (A[i / n][i % n] == 1)
                la.add(i / n * 100 + i % n);
            if (B[i / n][i % n] == 1)
                lb.add(i / n * 100 + i % n);
        }
        for (int a : la) {
            for (int b : lb) {
                count.put(a - b, count.getOrDefault(a - b, 0) + 1);
            }
        }
        int res = 0;
        for (int c : count.values())
            res = Math.max(c, res);
        return res;
    }
}
