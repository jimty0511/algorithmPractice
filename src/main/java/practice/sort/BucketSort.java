package practice.sort;

import java.util.Arrays;

/**
 * Best Case, Average: O(n+k)
 * Worst Case: O(n^2)
 */
public class BucketSort {
    public void bucketSort(int[] nums) {
        int i, j;
        int[] bucket = new int[nums.length + 1];
        Arrays.fill(bucket, 0);
        for (i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        int k = 0;
        for (i = 0; i < bucket.length; i++) {
            for (j = 0; j < bucket[i]; j++) {
                nums[k++] = i;
            }
        }
    }
}
