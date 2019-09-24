package practice.domain;

import java.util.Stack;

public class MyQueue {

//    Stack<Integer> input;
//    Stack<Integer> output;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public MyQueue() {
//        input = new Stack<>();
//        output = new Stack<>();
//    }
//
//    /**
//     * Push element x to the back of queue.
//     */
//    public void push(int x) {
//        input.push(x);
//    }
//
//    /**
//     * Removes the element from in front of queue and returns that element.
//     */
//    public int pop() {
//        peek();
//        return output.pop();
//    }
//
//    /**
//     * Get the front element.
//     */
//    public int peek() {
//        if (output.isEmpty())
//            while (!input.isEmpty())
//                output.push(input.pop());
//        return output.peek();
//    }
//
//    /**
//     * Returns whether the queue is empty.
//     */
//    public boolean empty() {
//        return input.isEmpty() && output.isEmpty();
//    }

    Stack<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        queue = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!queue.isEmpty()) {
            temp.push(queue.pop());
        }
        queue.push(x);
        while (!temp.isEmpty()) {
            queue.push(temp.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return queue.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return queue.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return queue.empty();
    }
}
