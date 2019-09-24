package practice.problem;

// https://leetcode.com/discuss/interview-question/124623/Facebook-or-Onsite-or-Variation-of-Dutch-National-Flag-problem
// https://knaidu.gitbooks.io/problem-solving/content/arrays/dutch_national_flag.html
public class DutchNationalFlagProblem {
    public void sortColors(int[] nums, int i) {
        int pivot = nums[i];
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] < pivot) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == pivot)
                mid++;
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
