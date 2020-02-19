package practice.lintcode;

import java.util.ArrayList;
import java.util.List;

// 147. Narcissistic Number
public class NarcissisticNumber {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < 10; i++)
                res.add(i);
            return res;
        }
        int start = pow(10, n - 1);
        int end = pow(10, n);
        for (int i = start; i < end; i++) {
            int tmp = i;
            int val = 0;
            while (tmp > 0) {
                val += pow((tmp % 10), n);
                tmp /= 10;
            }
            if (val == i)
                res.add(i);
        }
        return res;
    }

    private int pow(int a, int b) {
        int val = 1;
        for (int i = 1; i <= b; i++)
            val *= a;
        return val;
    }
}
