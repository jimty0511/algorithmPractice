package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 442. Find All Duplicates in an Array
// Microsoft ladder
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx - 1] > 0)
                nums[idx - 1] = -nums[idx - 1];
            else
                res.add(idx);
        }
        return res;
    }
}
