package practice.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 1007. Minimum Domino Rotations For Equal Row
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int[] countA = new int[7], countB = new int[7];
        for (int i = 0; i < A.length; i++) {
            set.retainAll(new HashSet<>(Arrays.asList(A[i], B[i])));
            countA[A[i]]++;
            countB[B[i]]++;
        }
        for (int i : set) {
            return Math.min(A.length - countA[i], B.length - countB[i]);
        }
        return -1;
    }

    public int minDominoRotationsTwo(int[] A, int[] B) {
        if (A.length != B.length)
            return -1;
        int[] countA = new int[7], countB = new int[7], same = new int[7];
        for (int i = 0; i < A.length; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i])
                same[A[i]]++;
        }
        for (int i = 1; i < 7; i++) {
            if (countA[i] + countB[i] - same[i] >= A.length)
                return Math.min(countA[i], countB[i]) - same[i];
        }
        return -1;
    }
}
