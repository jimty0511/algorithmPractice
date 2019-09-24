package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 368. Largest Divisible Subset
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n], pre = new int[n];
        Arrays.sort(nums);
        int max = 0, idx = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                idx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (idx != -1) {
            res.add(nums[idx]);
            idx = pre[idx];
        }
        return res;
    }
}
