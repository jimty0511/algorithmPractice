package practice.lintcode;

import java.util.Stack;

// 377. Stack Push-Pop Sequence
public class StackPushPopSequence {
    /**
     * @param push: the array push
     * @param pop:  the array pop
     * @return: return whether there are legal sequences
     */
    public boolean isLegalSeq(int[] push, int[] pop) {
        // write your code here
        if (push == null || pop == null || push.length != pop.length)
            return false;
        int m = push.length, n = pop.length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (push[i] != pop[j])
                return false;
            i--;
            j++;
        }
        return true;
    }

    public boolean isLegalSeqTwo(int[] push, int[] pop) {
        // write your code here
        if (push == null || pop == null || push.length != pop.length)
            return false;
        int m = push.length, n = pop.length;
        int i = 0, j = 0;
        Stack<Integer> stk = new Stack<>();
        while (i < m && j < n) {
            stk.push(push[i++]);
            while (!stk.isEmpty() && stk.peek() == pop[j]) {
                stk.pop();
                j++;
            }
        }
        return stk.isEmpty();
    }
}
