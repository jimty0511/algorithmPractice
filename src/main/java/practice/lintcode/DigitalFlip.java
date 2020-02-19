package practice.lintcode;

// 843. Digital Flip
public class DigitalFlip {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        // Write your code here
        int n = nums.length;
        int[] zero = new int[n + 1], one = new int[n + 1];
        zero[0] = one[0] = 0;
        for (int i = 1; i <= n; i++) {
            zero[i] = nums[i - 1] == 0 ? Math.min(one[i - 1], zero[i - 1]) : Math.min(one[i - 1], zero[i - 1]) + 1;
            one[i] = nums[i - 1] == 0 ? one[i - 1] + 1 : one[i - 1];
        }
        return Math.min(zero[n], one[n]);
    }
}
