package practice.problem;

// 735. Replace With Greatest From Right
public class ReplaceWithGreatestFromRight {
    public void arrayReplaceWithGreatestFromRight(int[] nums) {
        // Write your code here.
        int size = nums.length;
        int max = nums[size - 1];
        nums[size - 1] = -1;
        for (int i = size - 2; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = max;
            if (max < temp)
                max = temp;
        }
    }
}
