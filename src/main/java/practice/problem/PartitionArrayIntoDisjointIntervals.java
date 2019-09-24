package practice.problem;

// 915. Partition Array into Disjoint Intervals
public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        int localMax = A[0], resIdx = 0, max = localMax;
        for (int i = 1; i < A.length; i++) {
            if (localMax > A[i]) {
                localMax = max;
                resIdx = i;
            } else {
                max = Math.max(max, A[i]);
            }
        }
        return resIdx + 1;
    }

    public int partitionDisjointTwo(int[] A) {
        int n = A.length, preMax = 0;
        int[] B = new int[n];
        B[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            B[i] = Math.min(B[i + 1], A[i]);
        }
        for (int i = 1; i < n; i++) {
            preMax = Math.max(preMax, A[i - 1]);
            if (preMax <= B[i])
                return i;
        }
        return n;
    }
}
