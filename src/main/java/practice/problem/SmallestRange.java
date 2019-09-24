package practice.problem;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 632. Smallest Range
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o[0]).get(o[1])));
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            q.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (q.size() == nums.size()) {
            int cur[] = q.poll();
            int row = cur[0], col = cur[1];
            if (end - start > max - nums.get(row).get(col)) {
                start = nums.get(row).get(col);
                end = max;
            }
            if (col + 1 < nums.get(row).size()) {
                q.offer(new int[]{row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }
        return new int[]{start, end};
    }

    public int[] smallestRangeTwo(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(nums.size(), (a, b) -> a[0] - b[0]);
        int max = nums.get(0).get(0);
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(nums.get(i).get(0), max);
        }
        int minRange = Integer.MAX_VALUE;
        int start = -1;
        while (pq.size() == nums.size()) {
            int[] tmp = pq.poll();
            if (max - tmp[0] < minRange) {
                minRange = max - tmp[0];
                start = tmp[0];
            }
            if (tmp[2] < nums.get(tmp[1]).size() - 1) {
                tmp[0] = nums.get(tmp[1]).get(tmp[2] + 1);
                tmp[2]++;
                pq.offer(tmp);
                max = Math.max(max, tmp[0]);
            }
        }
        return new int[]{start, start + minRange};
    }

    public int[] smallestRangeThree(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(nums.size(), (a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(nums.get(i).get(0), max);
        }
        while (pq.size() == nums.size()) {
            int[] tmp = pq.poll();
            int val = tmp[0], row = tmp[1], col = tmp[2];
            if (max - val < end - start) {
                start = val;
                end = max;
            }
            if (col < nums.get(row).size() - 1) {
                tmp[0] = nums.get(row).get(col + 1);
                tmp[2]++;
                pq.offer(tmp);
                max = Math.max(max, tmp[0]);
            }
        }
        return new int[]{start, end};
    }
}
