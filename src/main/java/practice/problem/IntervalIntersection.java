package practice.problem;

import java.util.*;

// https://leetcode.com/discuss/interview-question/338948/Facebook-or-Onsite-or-Schedule-of-Tasks
public class IntervalIntersection {
    public int[][] intersection(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length, (a, b) -> a[1] - b[1]);
        List<int[]> res = new ArrayList<>();
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] peek = pq.peek();
            int[] cur = intervals[i];
            if (peek != null && cur[0] <= peek[1]) {
                if (cur[0] < peek[1]) {
                    int[] inter = new int[]{Math.max(peek[0], cur[0]), Math.min(peek[1], cur[1])};
                    res.add(inter);
                }
                pq.poll();
                int[] newInt = new int[]{peek[0], Math.max(peek[1], cur[1])};
                pq.offer(newInt);
            } else {
                pq.offer(cur);
            }
        }
        return res.toArray(new int[0][]);
    }
}
