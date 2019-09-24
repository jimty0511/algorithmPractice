package practice.problem;

import practice.domain.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 373. Find K Pairs with Smallest Sums
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0)
            return res;
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            res.add(new int[]{curr[0], curr[1]});
            if (curr[2] == nums2.length - 1)
                continue;
            pq.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }
        return res;
    }

    public List<int[]> kSmallestPairsTuple(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0)
            return res;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int m = nums1.length, n = nums2.length;
        for (int j = 0; j < n; j++) {
            pq.offer(new Tuple(0, j, nums1[0] + nums2[j]));
        }
        for (int i = 0; i < Math.min(k, m * n); i++) {
            Tuple t = pq.poll();
            res.add(new int[]{nums1[t.x], nums2[t.y]});
            if (t.x == m - 1)
                continue;
            pq.offer(new Tuple(t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }
        return res;
    }
}
