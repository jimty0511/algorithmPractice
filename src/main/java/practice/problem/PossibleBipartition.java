package practice.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 886. Possible Bipartition
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        boolean[][] g = new boolean[N][N];
        for (int[] d : dislikes) {
            g[d[0] - 1][d[1] - 1] = true;
            g[d[1] - 1][d[0] - 1] = true;
        }
        int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
            if (colors[i] == 0 && !helper(i, 1, colors, g))
                return false;
        }
        return true;
    }

    private boolean helper(int u, int color, int[] colors, boolean[][] g) {
        if (colors[u] != 0)
            return colors[u] == color;
        colors[u] = color;
        for (int v = 0; v < colors.length; v++) {
            if (g[u][v] && !helper(v, -color, colors, g))
                return false;
        }
        return true;
    }

    public boolean possibleBipartitionGraph(int N, int[][] dislikes) {
        int[] color = new int[N + 1];
        List<List<Integer>> adjs = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            adjs.add(new ArrayList<>());
        }
        for (int[] d : dislikes) {
            adjs.get(d[0]).add(d[1]);
            adjs.get(d[1]).add(d[0]);
        }
        for (int i = 1; i <= N; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int nb : adjs.get(cur)) {
                        if (color[nb] == 0) {
                            color[nb] = color[cur] == 1 ? 2 : 1;
                            q.offer(nb);
                        } else {
                            if (color[nb] == color[cur])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
