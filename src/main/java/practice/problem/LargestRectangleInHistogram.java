package practice.problem;

import java.util.Stack;

// 84. Largest Rectangle in Histogram
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height * (i - start - 1));
            }
            stack.push(i);
        }
        return maxArea;
    }
}
