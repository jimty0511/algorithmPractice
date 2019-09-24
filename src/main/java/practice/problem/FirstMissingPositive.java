package practice.problem;

// 41. First Missing Positive
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
//            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length)
//                i++;
//            else if (nums[nums[i] - 1] != nums[i])
//                swap(nums, i, nums[i] - 1);
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1)
            i++;
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
