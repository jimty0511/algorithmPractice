package practice.problem;

// 42. Trapping Rain Water
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3)
            return 0;
        int leftWall = height[0], rightWall = height[height.length - 1];
        int leftCur = 1, rightCur = height.length - 2, result = 0;
        while (leftCur <= rightCur) {
            if (leftWall <= rightWall) {
                result += Math.max(0, leftWall - height[leftCur]);
                leftWall = Math.max(leftWall, height[leftCur]);
                leftCur++;
            } else {
                result += Math.max(0, rightWall - height[rightCur]);
                rightWall = Math.max(rightWall, height[rightCur]);
                rightCur--;
            }
        }
        return result;
    }

    public int trapTwo(int[] height) {
        if (height.length < 3)
            return 0;
        int a = 0, b = height.length - 1;
        int max = 0, leftMax = 0, rightMax = 0;
        while (a <= b) {
            leftMax = Math.max(leftMax, height[a]);
            rightMax = Math.max(rightMax, height[b]);
            if (leftMax < rightMax) {
                max += leftMax - height[a];
                a++;
            } else {
                max += rightMax - height[b];
                b--;
            }
        }
        return max;
    }
}
