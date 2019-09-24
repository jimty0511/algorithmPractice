package practice.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1012. Numbers With Repeated Digits
public class NumbersWithRepeatedDigits {
    public int numDupDigitsAtMostN(int N) {
        List<Integer> list = new ArrayList<>();
        for (int x = N + 1; x > 0; x /= 10) {
            list.add(0, x % 10);
        }
        int res = 0, n = list.size();
        for (int i = 1; i < n; i++) {
            res += 9 * permutation(9, i - 1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i > 0 ? 0 : 1; j < list.get(i); j++) {
                if (!seen.contains(j))
                    res += permutation(9 - i, n - i - 1);
            }
            if (seen.contains(list.get(i)))
                break;
            seen.add(list.get(i));
        }
        return N - res;
    }

    private int permutation(int m, int n) {
        return n == 0 ? 1 : permutation(m, n - 1) * (m - n + 1);
    }
}
