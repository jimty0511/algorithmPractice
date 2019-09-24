package practice.problem;

// 280. Wiggle Sort
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i])
                    swap(nums, i);
            } else if (nums[i - 1] < nums[i])
                swap(nums, i);
        }
    }

    private void swap(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = temp;
    }
}
