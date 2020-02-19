package practice.lintcode;

import java.util.*;

// 1604. Maximum Sum of Two Numbers
public class MaximumSumOfTwoNumbers {
    /**
     * @param A: An Integer array
     * @return: returns the maximum sum of two numbers
     */
    public int MaximumSum(int[] A) {
        // write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int a : A) {
            int tmp = digitSum(a);
            map.putIfAbsent(tmp, new ArrayList<>());
            map.get(tmp).add(a);
        }
        int max = -1;
        for (int key : map.keySet()) {
            if (map.get(key).size() < 2)
                continue;
            List<Integer> nums = map.get(key);
            Collections.sort(nums);
            int n = nums.size();
            max = Math.max(max, nums.get(n - 1) + nums.get(n - 2));
        }
        return max;
    }

    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
