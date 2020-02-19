package practice.problem;

import java.util.HashSet;
import java.util.Set;

public class NumberofIntersectedRectangles {
    public int countIntersection(int[][][] rectangles) {
        if (rectangles == null || rectangles.length == 0)
            return 0;
        int n = rectangles.length;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(rectangles[i], rectangles[j])) {
                    int root1 = find(i, parents);
                    int root2 = find(j, parents);
                    if (root1 != root2)
                        parents[root1] = root2;
                }
            }
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++)
            res.add(find(i, parents));
        return res.size();
    }

    private int find(int val, int[] parents) {
        while (val != parents[val]) {
            val = parents[val];
        }
        return val;
    }

    private boolean intersect(int[][] r1, int[][] r2) {
        return Math.max(r1[0][0], r2[0][0]) < Math.min(r1[1][0], r2[1][0]) && Math.max(r1[0][1], r2[0][1]) < Math.min(r1[1][1], r2[1][1]);
//        return r1[0][0] < r2[1][0] && r2[0][0] < r1[1][0] && r1[0][1] < r2[1][1] && r2[0][1] < r1[1][1];
//        return r1[0][0] < r2[0][0] && r1[0][1] < r2[0][1] && r2[0][0] < r1[1][0] && r2[0][1] < r1[1][1] ||
//                r1[0][0] < r2[1][0] && r1[0][1] < r2[1][1] && r2[1][0] < r1[1][0] && r2[1][1] < r1[1][1];
    }
}
