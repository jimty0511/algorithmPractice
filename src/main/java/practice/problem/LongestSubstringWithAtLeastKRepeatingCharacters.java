package practice.problem;

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
}
