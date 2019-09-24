package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 248. Strobogrammatic Number III
public class StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        List<String> res = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); i++) {
            res.addAll(helper(i, i));
        }
        for (String s : res) {
            if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0))
                continue;
            count++;
        }
        return count;
    }

    private List<String> helper(int cur, int max) {
        if (cur == 0)
            return new ArrayList<>(Arrays.asList(""));
        if (cur == 1)
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> list = helper(cur - 2, max);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            if (cur != max)
                res.add("0" + temp + "0");
            res.add("1" + temp + "1");
            res.add("6" + temp + "9");
            res.add("8" + temp + "8");
            res.add("9" + temp + "6");
        }
        return res;
    }

    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public int strobogrammaticInRangeTwo(String low, String high) {
        int[] count = {0};
        for (int len = low.length(); len <= high.length(); len++) {
            char[] c = new char[len];
            helperTwo(low, high, c, 0, len - 1, count);
        }
        return count[0];
    }

    private void helperTwo(String low, String high, char[] c, int left, int right, int[] count) {
        if (left > right) {
            String s = new String(c);
            if ((s.length() == low.length() && s.compareTo(low) < 0) ||
                    (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            count[0]++;
            return;
        }
        for (char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];
            if (c.length != 1 && c[0] == '0')
                continue;
            if (left == right && p[0] != p[1])
                continue;
            helperTwo(low, high, c, left + 1, right - 1, count);
        }
    }
}
