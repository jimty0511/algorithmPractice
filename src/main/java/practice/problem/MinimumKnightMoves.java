package practice.problem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 1197. Minimum Knight Moves
public class MinimumKnightMoves {
    public int minKnightMoves(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[2]);
        int level = 0;
        int[][] dirs = {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == x && cur[1] == y)
                    return level;
                int hash = 1001 * cur[0] + cur[1];
                if (!visited.contains(hash)) {
                    for (int[] d : dirs) {
                        int r = cur[0] + d[0];
                        int c = cur[1] + d[1];
                        if (Math.abs(r) + Math.abs(c) > 300)
                            continue;
                        q.offer(new int[]{r, c});
                    }
                    visited.add(hash);
                }
            }
            level++;
        }
        return -1;
    }
}
