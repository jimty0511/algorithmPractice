package practice.problem;

// 487. Max Consecutive Ones II
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, zero = 0, k = 1, start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0)
                zero++;
            while (zero > k) {
                if (nums[start] == 0)
                    zero--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
