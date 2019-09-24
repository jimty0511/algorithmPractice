package practice.problem;

import java.util.Arrays;
import java.util.PriorityQueue;

// 870. Advantage Shuffle
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int n = A.length;
        int[] res = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++)
            pq.offer(new int[]{B[i], i});
        int low = 0, high = n - 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0], idx = cur[1];
            if (A[high] > val)
                res[idx] = A[high--];
            else
                res[idx] = A[low++];
        }
        return res;
    }
}
