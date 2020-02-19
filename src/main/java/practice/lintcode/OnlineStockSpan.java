package practice.lintcode;

import java.util.Stack;

// 1740. Online Stock Span
public class OnlineStockSpan {
    public OnlineStockSpan() {

    }

    Stack<int[]> stk = new Stack<>();

    /**
     * @param price:
     * @return: int
     */
    public int next(int price) {
        // Write your code here.
        int res = 1;
        while (!stk.isEmpty() && stk.peek()[0] <= price)
            res += stk.pop()[1];
        stk.push(new int[]{price, res});
        return res;
    }
}
