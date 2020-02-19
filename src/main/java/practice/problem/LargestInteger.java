package practice.problem;

import java.util.Arrays;

// https://leetcode.com/discuss/interview-question/406031/
public class LargestInteger {
    public int solution(int[] arr) {
        int res = 0;
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int sum = arr[l] + arr[r];
            if (sum == 0) {
                res = Math.max(res, arr[r]);
                l++;
                r--;
            } else if (sum < 0)
                l++;
            else
                r--;
        }
        return res;
    }
}
