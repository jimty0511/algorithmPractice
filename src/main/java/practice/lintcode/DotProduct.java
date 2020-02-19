package practice.lintcode;

// 1480. Dot Product
// Microsoft Ladder
public class DotProduct {
    /**
     * @param A: an array
     * @param B: an array
     * @return: dot product of two array
     */
    public int dotProduct(int[] A, int[] B) {
        // Write your code here
        if (A == null || A.length == 0 || B == null || B.length == 0 || A.length != B.length)
            return -1;
        int res = 0;
        for (int i = 0; i < A.length; i++)
            res += A[i] * B[i];
        return res;
    }
}
