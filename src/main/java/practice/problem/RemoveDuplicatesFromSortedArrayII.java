package practice.problem;

// 80. Remove Duplicates from Sorted Array II
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;
        int i = 1, j = 1, cnt = 1;
        while (j < n) {
            if (nums[j] != nums[j - 1]) {
                cnt = 1;
                nums[i++] = nums[j];
            } else {
                if (cnt < 2) {
                    nums[i++] = nums[j];
                    cnt++;
                }
            }
            j++;
        }
        return i;
    }

    public int removeDuplicatesShort(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
