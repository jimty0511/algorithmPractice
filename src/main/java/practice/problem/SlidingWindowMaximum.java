package practice.problem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

// 239. Sliding Window Maximum
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                answer[index++] = nums[q.peek()];
            }
        }
        return answer;

//        if (k < 2)
//            return nums;
//        int currentMax = Integer.MIN_VALUE, count = 0;
//        int[] answer = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length; i++) {
//            currentMax = currentMax < nums[i] ? nums[i] : currentMax;
//            count++;
//            if (count == k) {
//                answer[i - k + 1] = currentMax;
//                count--;
//                if (currentMax == nums[i - k + 1]) {
//                    currentMax = nums[i - k + 2];
//                    i = i - k + 1;
//                    count = 0;
//                }
//            }
//        }
//        return answer;  // 3,3,5,5,6,7
    }

    public int[] maxSlidingWindowPq(int[] nums, int k) {
        if (k < 2)
            return nums;
        PriorityQueue<Integer> pq = new PriorityQueue<>(3, (a, b) -> b - a);
        int count = 0;
        int[] answer = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() == k) {
                answer[count++] = pq.peek();
                i = i - k + 1;
                pq.clear();
            }
        }
        return answer;
    }
}
