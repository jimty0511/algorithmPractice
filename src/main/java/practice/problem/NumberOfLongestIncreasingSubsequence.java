package practice.problem;

// 673. Number of Longest Increasing Subsequence
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max = 0;
        int[] len = new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1)
                        cnt[i] += cnt[j];
                    else if (len[i] < len[j] + 1) { // found longer seq
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max == len[i])
                res += cnt[i];
            if (max < len[i]) {
                max = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
