package practice.problem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 340. Longest Substring with At Most K Distinct Characters
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() < 1)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0, maxLength = 0;
        while (high < s.length()) {
            if (map.size() <= k) {
                char c = s.charAt(high);
                map.put(c, high);
                high++;
            }
            if (map.size() > k) {
                int leftMost = s.length();
                for (int i : map.values()) {
                    leftMost = Math.min(leftMost, i);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                low = leftMost + 1;
            }
            maxLength = Math.max(maxLength, high - low);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringKDistinctLHM(String s, int k) {
        int left = 0, max = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.remove(c);
            map.put(c, i);
            if (map.size() > k) {
                char next = map.keySet().iterator().next();
                left = map.get(next) + 1;
                map.remove(next);
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstringKDistinctThree(String s, int k) {
        int[] cnt = new int[256];
        char[] chars = s.toCharArray();
        int sum = 0, res = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            cnt[chars[r]]++;
            if (cnt[chars[r]] == 1)
                sum++;
            while (sum > k) {
                cnt[chars[l]]--;
                if (cnt[chars[l]] == 0)
                    sum--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
