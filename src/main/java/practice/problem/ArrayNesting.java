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

    /**
     * @param nums: an array
     * @return: the longest length of set S
     */
    public int arrayNestingTwo(int[] nums) {
        // Write your code here
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            int idx = i;
            while (nums[idx] != -1) {
                int next = nums[idx];
                nums[idx] = -1;
                idx = next;
                size++;
            }
            max = Math.max(max, size);
        }
        return max;
    }
}
