package practice.problem;

// 665. Non-decreasing Array
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int modified = 0;
        for (int i = 1, prev = nums[0]; i < nums.length; i++) {
            if (nums[i] < prev) {
                if (modified++ > 0)
                    return false;
                if (i - 2 >= 0 && nums[i - 2] > nums[i])
                    continue;
            }
            prev = nums[i];
        }
        return true;
    }

    public boolean checkPossibilityTwo(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];
                else
                    nums[i] = nums[i - 1];
            }
        }
        return cnt <= 1;
    }
}
