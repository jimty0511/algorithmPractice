package practice.problem;

import java.util.LinkedList;
import java.util.List;

// 989. Add to Array-Form of Integer
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int cur = A[i] + K;
            res.add(0, cur % 10);
            K = cur / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
}
