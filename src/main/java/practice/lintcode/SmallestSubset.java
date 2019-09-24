package practice.lintcode;

import java.util.Arrays;

// 761. Smallest Subset
public class SmallestSubset {
    public int minElements(int[] arr) {
        // write your code here
        int sum = 0;
        for (int a : arr)
            sum += a;
        sum /= 2;
        Arrays.sort(arr);
        int res = 0, curSum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            curSum += arr[i];
            res++;
            if (curSum > sum)
                return res;
        }
        return res;
    }
}
