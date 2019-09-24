package practice.problem;

// 1089. Duplicate Zeros
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        for (int a : arr) {
            if (a == 0)
                count++;
        }
        int len = arr.length + count;
        for (int i = arr.length - 1, j = len - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length)
                    arr[j] = arr[i];
            } else {
                if (j < arr.length)
                    arr[j] = arr[i];
                j--;
                if (j < arr.length)
                    arr[j] = arr[i];
            }
        }
    }
}
