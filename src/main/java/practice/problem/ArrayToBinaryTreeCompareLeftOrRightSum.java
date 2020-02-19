package practice.problem;

public class ArrayToBinaryTreeCompareLeftOrRightSum {
    public String solution(long[] arr) {
        // Type your solution here;
        int level = 1;
        int idx = 1;
        long leftSum = 0, rightSum = 0;
        while (idx < arr.length) {
            for (int i = 0; i < level && idx < arr.length; i++) {
                if (arr[idx] != -1)
                    leftSum += arr[idx];
                idx++;
            }
            for (int i = 0; i < level && idx < arr.length; i++) {
                if (arr[idx] != -1)
                    rightSum += arr[idx];
                idx++;
            }
            level *= 2;
        }
        if (leftSum > rightSum)
            return "Left";
        else if (rightSum > leftSum)
            return "Right";
        else
            return "";
    }
}
