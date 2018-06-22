package practice.problem;

import java.util.PriorityQueue;
import java.util.TreeSet;

// 264. Ugly Number II
public class UglyNumberII {
    public int nthUglyNumber(int n) {
//        int[] ugly = new int[n];
//        ugly[0] = 1;
//        int c2 = 0, c3 = 0, c5 = 0;
//        for (int i = 1; i < n; i++) {
//            while (ugly[c2] * 2 <= ugly[i - 1]) {
//                c2++;
//            }
//            while (ugly[c3] * 3 <= ugly[i - 1]) {
//                c3++;
//            }
//            while (ugly[c5] * 5 <= ugly[i - 1]) {
//                c5++;
//            }
//            ugly[i] = Math.min(ugly[c2] * 2, Math.min(ugly[c3] * 3, ugly[c5] * 5));
//        }
//        return ugly[n - 1];

//        if (n == 1) {
//            return 1;
//        }
//        PriorityQueue<Long> q = new PriorityQueue<>();
//        q.add(1l);
//
//        for (long i = 1; i < n; i++) {
//            long tmp = q.poll();
//            while (!q.isEmpty() && q.peek() == tmp) {
//                tmp = q.poll();
//            }
//            q.add(tmp * 2);
//            q.add(tmp * 3);
//            q.add(tmp * 5);
//        }
//        return q.poll().intValue();

        TreeSet<Long> res = new TreeSet<>();
        res.add(1l);
        for (int i = 0; i < n - 1; ++i) {
            long first = res.pollFirst();
            res.add(first * 2);
            res.add(first * 3);
            res.add(first * 5);
        }
        return res.first().intValue();
    }

    public int nthUglyNumberDp(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min)
                factor2 = 2 * ugly[++index2];
            if (factor3 == min)
                factor3 = 3 * ugly[++index3];
            if (factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }
}
