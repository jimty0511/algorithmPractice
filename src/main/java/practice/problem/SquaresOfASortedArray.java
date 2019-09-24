package practice.problem;

// 977. Squares of a Sorted Array
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int i = 0, j = len - 1;
        for (int p = len - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[p] = A[i] * A[i];
                i++;
            } else {
                res[p] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }
}
