package practice.problem;

import java.util.Stack;

// 85. Maximal Rectangle
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1')
                height[i] = 1;
        }
        int result = largestInLine(height);
        for (int i = 1; i < matrix.length; i++) {
            resetHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }
        return result;
    }

    private void resetHeight(char[][] matrix, int[] height, int idx) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[idx][i] == '1')
                height[i] += 1;
            else
                height[i] = 0;
        }
    }

    private int largestInLine(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == len ? 0 : heights[i];
//            while (!stack.isEmpty() && h < height[stack.peek()]) {
//                int newH = height[stack.pop()];
//                int start = stack.isEmpty() ? -1 : stack.peek();
//                maxArea = Math.max(maxArea, newH * (i - start - 1));
//            }
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int height = heights[stack.pop()];
                maxArea = Math.max(maxArea, height * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
            stack.push(i);
        }
        return maxArea;
    }

    public int maximalRectangle(boolean[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!matrix[i][j]) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, helper(height[i]));
        }
        return res;
    }

    private int helper(int[] height) {
        Stack<Integer> stk = new Stack<>();
        int len = height.length;
        int max = 0;
        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : height[i];
            while (!stk.isEmpty() && h < height[stk.peek()]) {
                int tmp = height[stk.pop()];
                int start = stk.isEmpty() ? -1 : stk.peek();
                max = Math.max(max, tmp * (i - start - 1));
            }
            stk.push(i);
        }
        return max;
    }
}
