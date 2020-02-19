package practice.problem;

// 1144. Decrease Elements To Make Array Zigzag
public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int[] res = new int[2];
        int n = nums.length, left, right;
        for (int i = 0; i < nums.length; i++) {
            left = i > 0 ? nums[i - 1] : 1001;
            right = i + 1 < n ? nums[i + 1] : 1001;
            res[i % 2] += Math.max(0, nums[i] - Math.min(left, right) + 1);
        }
        return Math.min(res[0], res[1]);
    }
}
