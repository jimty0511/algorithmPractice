package practice.problem;

import java.util.Arrays;

// 395. Longest Substring with At Least K Repeating Characters
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        return longestSubstringHelper(chars, 0, s.length(), k);
    }

    private int longestSubstringHelper(char[] chars, int start, int end, int k) {
        if (end - start < k)
            return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            int idx = chars[i] - 'a';
            count[idx]++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) {
                for (int j = start; j < end; j++) {
                    if (chars[j] == i + 'a') {
                        int left = longestSubstringHelper(chars, start, j, k);
                        int right = longestSubstringHelper(chars, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }

    public int longestSubstringTwo(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;
        for (h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            i = 0;
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                } else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }
        return max;
    }
}
