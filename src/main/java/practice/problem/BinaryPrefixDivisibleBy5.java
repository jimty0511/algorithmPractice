package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 1018. Binary Prefix Divisible By 5
public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int k = 0;
        List<Boolean> res = new ArrayList<>();
        for (int a : A) {
            k = (k << 1 | a) % 5;
            res.add(k == 0);
        }
        return res;
    }
}
