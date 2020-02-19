package practice.lintcode;

import java.util.ArrayList;
import java.util.List;

// 371. Print Numbers by Recursion
public class PrintNumbersByRecursion {
    /**
     * @param n: An integer
     * @return: An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (n == 0)
            return res;
        res = numbersByRecursion(n - 1);
        for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
            res.add(i);
        }
        return res;
    }
}
