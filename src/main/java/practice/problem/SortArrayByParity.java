package practice.problem;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int size = A.length;
        int start = 0, end = size - 1;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            if (A[i] % 2 == 1) {
                res[end--] = A[i];
            } else {
                res[start++] = A[i];
            }
        }
        return res;
    }
}
