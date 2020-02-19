package practice.lintcode;

import java.util.*;

// 1674. Pouring cola
public class PouringCola {
    /**
     * @param s: the volume of cola
     * @param n: the volume of the first cup
     * @param m: the volume of the second cup
     * @return: the minimum number of times to be inverted
     */
    public int getMinTimes(int s, int n, int m) {
        // Write your code here
        if (s % 2 != 0)
            return -1;
        int target = s / 2, step = 0;
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0, 0});
        visited.add(Arrays.toString(new int[]{s, 0, 0}));
        int[][] dirs = new int[][]{{-n, n, 0}, {-m, 0, m}, {n, -n, 0}, {m, 0, -m}, {0, -n, n}, {0, m, -m}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == target && (cur[1] == target || cur[2] == target))
                    return step - 1;
                for (int[] d : dirs) {
                    int x = cur[0] + d[0], y = cur[1] + d[1], z = cur[2] + d[2];
                    if (x < 0 || x > s || y < 0 || y > n || z < 0 || z > m)
                        continue;
                    int[] next = new int[]{x, y, z};
                    if (visited.add(Arrays.toString(next)))
                        q.offer(next);
                }
            }
            step++;
        }
        return -1;
    }
}
