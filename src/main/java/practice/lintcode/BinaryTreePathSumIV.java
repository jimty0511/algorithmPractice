package practice.lintcode;

import java.util.Arrays;

// 863. Binary Tree Path Sum IV LC
public class BinaryTreePathSumIV {

    int ans = 0, depth = 0;

    public int pathSum(int[] nums) {
        // write your code here
        int n = nums.length;
        depth = nums[n - 1] / 100;
        int cols = 1;
        for (int i = 0; i < depth; i++)
            cols *= 2;
        int[][] graph = new int[depth][cols];
        for (int i = 0; i < depth; i++)
            Arrays.fill(graph[i], -1);
        for (int i = 0; i < n; i++) {
            int d = nums[i] / 100, c = nums[i] / 10 % 10;
            graph[d - 1][c - 1] = nums[i] % 10;
        }
        helper(graph, 0, 0, 0);
        return ans;
    }

    private void helper(int[][] graph, int d, int c, int sum) {
        if (graph[d][c] == -1)
            return;
        sum += graph[d][c];
        if (d == depth - 1 || (graph[d + 1][2 * c] == -1 && graph[d + 1][2 * c + 1] == -1)) {
            ans += sum;
            return;
        }
        helper(graph, d + 1, 2 * c, sum);
        helper(graph, d + 1, 2 * c + 1, sum);
    }
}
