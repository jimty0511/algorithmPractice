package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 247. Strobogrammatic Number II
public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int n, int m) {
        if (n == 0)
            return new ArrayList<>(Arrays.asList(""));
        if (n == 1)
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m)
                res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }

    public List<String> findStrobogrammaticIter(int n) {
        List<String> cur = new ArrayList<>();
        List<String> res = new ArrayList<>((n & 1) == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));
        if (n < 2)
            return res;
        for (; n > 1; n -= 2) {
            cur = res;
            res = new ArrayList<>();
            for (String s : cur) {
                if (n > 3)
                    res.add('0' + s + '0');
                res.add('1' + s + '1');
                res.add('8' + s + '8');
                res.add('6' + s + '9');
                res.add('9' + s + '6');
            }
        }
        return res;
    }

}
