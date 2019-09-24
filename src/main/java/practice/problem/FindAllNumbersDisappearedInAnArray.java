package practice.problem;

import java.util.*;

// 448. Find All Numbers Disappeared in an Array
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)
                nums[val] = -nums[val];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }

    public List<Integer> findDisappearedNumbersTwo(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i))
                res.add(i);
        }
        return res;
    }
}
