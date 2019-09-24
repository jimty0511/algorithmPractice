package practice.problem;

import java.util.PriorityQueue;

// 1005. Maximize Sum Of Array After K Negations
public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : A)
            pq.add(a);
        while (K-- > 0)
            pq.add(-pq.poll());
        int sum = 0;
        for (int i = 0; i < A.length; i++)
            sum += pq.poll();
        return sum;
    }
}
