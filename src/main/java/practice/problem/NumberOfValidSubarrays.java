package practice.problem;

import java.util.Stack;

// 1063.Number of Valid Subarrays
public class NumberOfValidSubarrays {
    public int solution(int[] nums) {
        int res = 0;
        Stack<Integer> stk = new Stack<>();
        for (int n : nums) {
            while (!stk.isEmpty() && stk.peek() > n)
                stk.pop();
            stk.push(n);
            res += stk.size();
        }
        return res;
    }
}
