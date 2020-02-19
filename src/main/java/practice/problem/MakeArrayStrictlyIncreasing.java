package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

// 1187. Make Array Strictly Increasing
public class MakeArrayStrictlyIncreasing {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0)
            return -1;
        if (arr1.length == 1)
            return 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int a : arr2)
            ts.add(a);
        int[][] dp = new int[arr1.length + 1][arr1.length + 1];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = Integer.MIN_VALUE;
        for (int j = 1; j < dp.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (arr1[j - 1] > dp[i][j - 1])
                    dp[i][j] = arr1[j - 1];
                if (i > 0 && ts.higher(dp[i - 1][j - 1]) != null)
                    dp[i][j] = Math.min(dp[i][j], ts.higher(dp[i - 1][j - 1]));
                if (j == dp.length - 1 && dp[i][j] != Integer.MAX_VALUE)
                    return i;
            }
        }
        return -1;
    }

    public int makeArrayIncreasingTwo(int[] arr1, int[] arr2) {
        int len = arr1.length;
        Arrays.sort(arr2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            if (i + 1 < arr2.length && arr2[i] == arr2[i + 1])
                continue;
            list.add(arr2[i]);
        }
        int[] newArr2 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newArr2[i] = list.get(i);
        }
        arr2 = newArr2;
        int[] newArr1 = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newArr1[i + 1] = arr1[i];
        }
        newArr1[len + 1] = Integer.MAX_VALUE;
        newArr1[0] = Integer.MIN_VALUE;
        arr1 = newArr1;
        int[] dp = new int[len + 2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 1; j < len + 2; j++) {
            for (int i = 0; i < j; i++) {
                if (arr1[i] < arr1[j] && dp[i] != Integer.MAX_VALUE) {
                    int change = numberCouldSwap(arr1, arr2, i, j);
                    if (change >= 0)
                        dp[j] = Math.min(dp[j], dp[i] + change);
                }

            }
        }
        return dp[len + 1] == Integer.MAX_VALUE ? -1 : dp[len + 1];
    }

    private int numberCouldSwap(int[] arr1, int[] arr2, int start, int end) {
        if (start + 1 == end)
            return 0;
        int min = arr1[start], max = arr1[end];
        int idx = Arrays.binarySearch(arr2, min);
        if (idx < 0)
            idx = -idx - 1;
        else
            idx = idx + 1;
        int maxCnt = end - start - 1;
        int endIdx = idx + maxCnt - 1;
        if (endIdx < arr2.length && arr2[endIdx] < max)
            return maxCnt;
        return -1;
    }
}
