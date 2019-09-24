package practice.problem;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/discuss/interview-question/349687/Facebook-or-Onsite-or-Min-steps-to-remove-elements
public class MinStepsToRemoveElements {
    public int solve(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] level = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            while (deque.size() > 0 && nums[deque.peekLast()] >= nums[i]) {
                tmp = Math.max(tmp, level[deque.peekLast()] + 1);
                deque.pollLast();
            }
            if (deque.size() == 0)
                tmp = 0;
            max = Math.max(max, tmp);
            level[i] = tmp;
            deque.offerLast(i);
        }
        return max + 1;
    }
}
