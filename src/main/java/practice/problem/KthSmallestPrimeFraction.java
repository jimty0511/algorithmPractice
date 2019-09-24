package practice.problem;

import java.util.PriorityQueue;

// 786. K-th Smallest Prime Fraction
public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (A[a[0]] * A[b[1]] - A[b[0]] * A[a[1]]));
        for (int i = 0; i < n - 1; i++) {
            pq.add(new int[]{i, n - 1});
        }
        for (int i = 0; i < K - 1; i++) {
            int[] pop = pq.remove();
            int ni = pop[0], di = pop[1];
            if (pop[1] - 1 > pop[0]) {
                pop[1]--;
                pq.add(pop);
            }
        }
        int[] peek = pq.peek();
        return new int[]{A[peek[0]], A[peek[1]]};
    }
}
