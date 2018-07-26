package practice.problem;

// 485. Max Consecutive Ones
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, sum = 0;
        for (int n : nums) {
            sum += 1;
            if (n == 0) {
                sum = 0;
            } else {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
