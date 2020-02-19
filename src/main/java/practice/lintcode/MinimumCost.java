package practice.lintcode;

import java.util.*;

// 1696. Minimum Cost
public class MinimumCost {
    /**
     * @param a: the array a
     * @return: return the minumum cost
     */
    public int getAns(int[] a) {
        // write your code here
        if (a.length < 3)
            return 0;
        if (a.length == 3)
            return a[0] * a[1] * a[3];
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            list.add(a[i]);
        while (list.size() > 4) {
            int idx = -1, min = Integer.MAX_VALUE;
            for (int i = 2; i < list.size() - 2; i++) {
                int sum = list.get(i - 1) * list.get(i) * list.get(i + 1);
                if (sum < min) {
                    min = sum;
                    idx = i;
                }
            }
            res += min;
            list.remove(idx);
        }
        int idx = -1, min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size() - 1; i++) {
            int sum = list.get(i - 1) * list.get(i) * list.get(i + 1);
            if (sum < min) {
                min = sum;
                idx = i;
            }
        }
        res += min;
        list.remove(idx);
        res += list.get(0) * list.get(1) * list.get(2);
        return res;
    }
}
