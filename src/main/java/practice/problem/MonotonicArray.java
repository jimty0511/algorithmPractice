package practice.problem;

// 896. Monotonic Array
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        int inc = 1, dec = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1])
                inc++;
            else if (A[i] < A[i - 1])
                dec++;
            else {
                inc++;
                dec++;
            }
        }
        return inc == A.length || dec == A.length;
    }
}
