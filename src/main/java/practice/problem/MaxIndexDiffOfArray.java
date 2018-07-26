package practice.problem;

// https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
public class MaxIndexDiffOfArray {
    public int maxIndexDiff(int arr[], int n) {
        int maxDiff = -1;
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = n - 1; j >= i; j--) {
                if (arr[j] > arr[i] && maxDiff < (j - i)) {
                    maxDiff = j - i;
                }
            }
        }
        return maxDiff;
    }

    public int maxIndexDiffTwo(int arr[], int n) {
        int i, j;
        int rightMax[] = new int[n];
        int leftMin[] = new int[n];
        leftMin[0] = arr[0];
        rightMax[n - 1] = arr[n - 1];
        for (i = 1; i < n; i++) {
            leftMin[i] = Math.min(arr[i], leftMin[i - 1]);
        }
        for (j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(arr[j], rightMax[j + 1]);
        }
        i = 0;
        j = 0;
        int maxDiff = -1;
        while (j < n && i < n) {
            if (leftMin[i] < rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }
}
