package practice.sort;

/**
 * Sorts 32-bit integers with O(n*k) runtime performance.
 * Where k is the max number of digits of the numbers being
 * sorted.
 */
public class RadixSort {

    public int[] radixSort(int[] nums) {
        int m = nums[0];
        for (int n : nums) {
            m = Math.max(m, n);
        }
        int[] out = new int[nums.length];
        int place = 1;
        while (m / place > 0) {
            int[] count = new int[10];
            for (int i = 0; i < nums.length; i++) {
                int digit = (nums[i] / place) % 10;
                count[digit]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                int digit = (nums[i] / place) % 10;
                out[count[digit] - 1] = nums[i];
                count[digit]--;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = out[i];
            }
            place *= 10;
        }
        return out;
    }
}
