package practice.problem;

import java.util.PriorityQueue;

// 502. IPO
public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> capitalPq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> profitPq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < Profits.length; i++) {
            capitalPq.offer(new int[]{Capital[i], Profits[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!capitalPq.isEmpty() && capitalPq.peek()[0] <= W)
                profitPq.offer(capitalPq.poll());
            if (profitPq.isEmpty())
                break;
            W += profitPq.poll()[1];
        }
        return W;
    }
}
