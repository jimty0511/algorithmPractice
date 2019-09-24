package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 260. Single Number III
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public int[] singleNumberTwo(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n))
                set.remove(n);
        }
        return set.stream().mapToInt(n -> n).toArray();
    }
}
