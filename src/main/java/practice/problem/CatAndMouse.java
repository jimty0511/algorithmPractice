package practice.problem;

import java.util.Arrays;

// 913. Cat and Mouse
public class CatAndMouse {
    // dp[mouse][cat] position for mouse and cat
    public int catMouseGame(int[][] graph) {
        int size = graph.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++)
            Arrays.fill(dp[i], -1);
        for (int i = 1; i < size; i++) {
            dp[0][i] = 1; // mouse win
            dp[i][i] = 2; // cat win
        }
        return helper(graph, 1, 2, dp);
    }

    private int helper(int[][] graph, int mouse, int cat, int[][] dp) {
        if (dp[mouse][cat] != -1)
            return dp[mouse][cat];
        dp[mouse][cat] = 0;
        int mouseDefault = 2;
        int[] mouseGoList = graph[mouse], catGoList = graph[cat];
        for (int mouseGo : mouseGoList) {
            if (mouseGo == cat)
                continue;
            int catDefault = 1;
            for (int catGo : catGoList) {
                if (catGo == 0)
                    continue;
                int next = helper(graph, mouseGo, catGo, dp);
                if (next == 2) {
                    catDefault = 2;
                    break;
                }
                if (next == 0)
                    catDefault = 0;
            }
            if (catDefault == 1) {
                mouseDefault = 1;
                break;
            }
            if (catDefault == 0)
                mouseDefault = 0;
        }
        dp[mouse][cat] = mouseDefault;
        return mouseDefault;
    }
}
