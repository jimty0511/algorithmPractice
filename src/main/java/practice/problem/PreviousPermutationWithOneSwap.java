package practice.problem;

// 1053. Previous Permutation With One Swap
public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] A) {
        int n = A.length, left = n - 2, right = n - 1;
        while (left >= 0 && A[left] <= A[left + 1])
            left--;
        if (left < 0)
            return A;
        while (A[left] <= A[right])
            right--;
        while (A[right - 1] == A[right])
            right--;
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
        return A;
    }
}
