package practice.problem;

import java.util.Arrays;

// 899. Orderly Queue
public class OrderlyQueue {
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String res = S;
        for (int i = 1; i < S.length(); i++) {
            String tmp = S.substring(i) + S.substring(0, i);
            if (res.compareTo(tmp) > 0)
                res = tmp;
        }
        return res;
    }
}
