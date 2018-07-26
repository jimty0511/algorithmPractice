package practice.problem;

// 453. Minimum Moves to Equal Array Elements
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int res = 0;
        for (int n : nums) {
            res += n - min;
        }
        return res;
    }
}
