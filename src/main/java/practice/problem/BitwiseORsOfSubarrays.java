package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 898. Bitwise ORs of Subarrays
public class BitwiseORsOfSubarrays {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>(), cur = new HashSet<>(), tmp;
        for (int a : A) {
            tmp = new HashSet<>();
            tmp.add(a);
            for (int c : cur)
                tmp.add(a | c);
            res.addAll(tmp);
            cur = tmp;
        }
        return res.size();
    }
}
