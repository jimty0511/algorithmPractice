package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 888. Fair Candy Swap
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            sumA += a;
            set.add(a);
        }
        for (int b : B) {
            sumB += b;
        }
        int diff = (sumA - sumB) / 2;
        for (int b : B) {
            int target = b + diff;
            if (set.contains(target))
                return new int[]{target, b};
        }
        return null;
    }
}
