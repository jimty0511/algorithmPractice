package practice.problem;

// 565. Array Nesting
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int k = i; nums[k] >= 0; size++) {
                int idx = nums[k];
                nums[k] = -1;
                k = idx;
            }
            max = Math.max(size, max);
        }
        return max;
    }
}
