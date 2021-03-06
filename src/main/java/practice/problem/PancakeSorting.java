package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 969. Pancake Sorting
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int n = A.length, largest = n;
        for (int i = 0; i < n; i++) {
            int index = find(A, largest);
            flip(A, index);
            flip(A, largest - 1);
            res.add(index + 1);
            res.add(largest--);
        }
        return res;
    }

    private int find(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target)
                return i;
        }
        return -1;
    }

    private void flip(int[] A, int index) {
        int i = 0, j = index;
        while (i < j) {
            int temp = A[i];
            A[i++] = A[j];
            A[j--] = temp;
        }
    }
}
