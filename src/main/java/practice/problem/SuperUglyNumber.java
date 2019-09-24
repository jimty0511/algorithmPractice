package practice.problem;

import java.util.Arrays;
import java.util.PriorityQueue;

// 313. Super Ugly Number
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i])
                    idx[j]++;
            }
        }
        return ugly[n - 1];
    }

    public int nthSuperUglyNumberTwo(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);
        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (val[j] == ugly[i])
                    val[j] = ugly[idx[j]++] * primes[j];
                next = Math.min(next, val[j]);
            }
        }
        return ugly[n - 1];
    }

    public int nthSuperUglyNumberThree(int n, int[] primes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new int[]{primes[i], 0, primes[i]});
        }
        for (int i = 1; i < n; i++) {
            int next = pq.peek()[0];
            ans[i] = next;
            while (pq.peek()[0] == next) {
                int[] cur = pq.poll();
                cur[0] = cur[2] * ans[cur[1]];
                cur[1] = cur[1] + 1;
                pq.offer(cur);
            }
        }
        return ans[n - 1];
    }
}
