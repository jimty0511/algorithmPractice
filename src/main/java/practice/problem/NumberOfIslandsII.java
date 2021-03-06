package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 305. Number of Islands II
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (m <= 0 || n <= 0)
            return result;
        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] p : positions) {
            int root = n * p[0] + p[1];
            roots[root] = root;
            count++;
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = n * x + y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1)
                    continue;
                int rootNb = find(roots, nb);
                if (root != rootNb) {
                    roots[root] = rootNb;
                    root = rootNb;
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    private int find(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
