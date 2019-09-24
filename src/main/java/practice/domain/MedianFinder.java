package practice.domain;

import java.util.Collections;
import java.util.PriorityQueue;

// 295. Find Median from Data Stream
public class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    boolean even;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
        even = true;
    }

    public void addNum(int num) {
        if (even) {
            max.offer(num);
            min.offer(max.poll());
        } else {
            min.offer(num);
            max.offer(min.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even)
            return (max.peek() + min.peek()) / 2.0;
        else
            return min.peek();
    }
}
