package practice.sort;

/**
 * Best Case, Average, Worst Case: O(nlog(n))
 */
public class MergeSort {
    int[] tempArr;

    public void sort(int arr[]) {
        tempArr = new int[arr.length];
        doMergeSort(arr, 0, arr.length - 1);
    }

    public void doMergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            doMergeSort(arr, left, mid);
            doMergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int arr[], int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tempArr[i] = arr[i];
        }
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (tempArr[i] <= tempArr[j]) {
                arr[k] = tempArr[i];
                i++;
            } else {
                arr[k] = tempArr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = tempArr[i];
            k++;
            i++;
        }
    }
}
