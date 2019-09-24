package practice.domain;

import java.util.Stack;

public class MinStack {

    Stack<Integer> mainStack, minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        mainStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (mainStack.empty()) {
            return;
        }
        int popValue = mainStack.pop();
        if (!minStack.empty() && popValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        if (!minStack.empty()) {
            return minStack.peek();
        } else {
            return mainStack.peek();
        }
    }
}
