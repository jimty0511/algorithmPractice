package practice.lintcode;

import java.util.HashSet;
import java.util.Set;

// 645. Set Mismatch (1112 LC)
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int dup = 0, n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i : nums) {
            if (!set.add(i))
                dup = i;
            sum -= i;
        }
        return new int[]{dup, sum + dup};
    }
}
