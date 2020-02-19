package practice.problem;

import java.util.LinkedList;
import java.util.Queue;

// 346. Moving Average from Data Stream
// Microsoft Ladder
public class MovingAverage {

    private double preSum = 0.0;
    private Queue<Integer> queue;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            preSum -= queue.remove();
        }
        preSum += val;
        queue.add(val);
        return preSum / queue.size();
    }
}
