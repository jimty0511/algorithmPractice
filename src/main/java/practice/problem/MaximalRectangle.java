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

    private int largestInLine(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= height.length; i++) {
            int h = i == len ? 0 : height[i];
            while (!stack.isEmpty() && h < height[stack.peek()]) {
                int newH = height[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, newH * (i - start - 1));
            }
            stack.push(i);
        }
        return maxArea;
    }
}
