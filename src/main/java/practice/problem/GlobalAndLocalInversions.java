package practice.problem;

// 775. Global and Local Inversions
public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 2; i++) {
            max = Math.max(A[i], max);
            if (max > A[i + 2])
                return false;
        }
        return true;
    }
}
