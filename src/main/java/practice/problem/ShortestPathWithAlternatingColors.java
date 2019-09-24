package practice.problem;

import java.util.*;

// 1129. Shortest Path with Alternating Colors
public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        List<Integer>[] reds = new List[n], blues = new List[n];
        for (int[] e : red_edges) {
            if (reds[e[0]] == null)
                reds[e[0]] = new ArrayList<>();
            reds[e[0]].add(e[1]);
        }
        for (int[] e : blue_edges) {
            if (blues[e[0]] == null)
                blues[e[0]] = new ArrayList<>();
            blues[e[0]].add(e[1]);
        }
        Queue<int[]> q = new LinkedList<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        q.offer(new int[]{0, 0});
        int moves = 0;
        Set<String> seen = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                String key = cur[0] + " " + cur[1];
                if (seen.contains(key))
                    continue;
                seen.add(key);
                if (res[cur[0]] == -1)
                    res[cur[0]] = moves;
                if (cur[1] == 2 || cur[1] == 0) {
                    if (reds[cur[0]] != null) {
                        for (int child : reds[cur[0]])
                            q.offer(new int[]{child, 1});
                    }
                }
                if (cur[1] == 1 || cur[1] == 0) {
                    if (blues[cur[0]] != null) {
                        for (int child : blues[cur[0]])
                            q.offer(new int[]{child, 2});
                    }
                }
            }
            moves++;
        }
        return res;
    }
}
