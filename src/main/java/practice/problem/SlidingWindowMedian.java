package practice.problem;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

// 480. Sliding Window Median
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (left.size() <= right.size()) {
                right.offer(nums[i]);
                left.offer(right.poll());
            } else {
                left.offer(nums[i]);
                right.offer(left.poll());
            }
            if (left.size() + right.size() == k) {
                double median;
                if (left.size() == right.size()) {
                    median = (double) ((long) left.peek() + (long) right.peek()) / 2;
                } else {
                    median = (double) left.peek();
                }
                int idx = i - k + 1;
                res[idx] = median;
                if (!left.remove(nums[idx])) {
                    right.remove(nums[idx]);
                }
            }
        }
        return res;
    }

    public double[] medianSlidingWindowTs(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        TreeSet<Integer> left = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[b] < nums[a] ? -1 : 1);
        TreeSet<Integer> right = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] < nums[b] ? -1 : 1);
        for (int i = 0; i < nums.length; i++) {
            if (left.size() <= right.size()) {
                right.add(i);
                left.add(right.pollFirst());
            } else {
                left.add(i);
                right.add(left.pollFirst());
            }
            if (left.size() + right.size() == k) {
                double median;
                if (left.size() == right.size()) {
                    median = ((double) nums[left.first()] + nums[right.first()]) / 2;
                } else
                    median = nums[left.first()];
                int idx = i - k + 1;
                res[idx] = median;
                if (!left.remove(idx)) {
                    right.remove(idx);
                }
            }
        }
        return res;
    }
}
