package practice.problem;

// https://leetcode.com/discuss/interview-question/398037/
public class LongestSemiAlternatingSubstring {
    public String solution(String s) {
        int cnt = 1, l = 0, last = 0;
        int maxLen = Integer.MIN_VALUE;
        String res = "";
        for (int r = 1; r < s.length(); r++) {
            char c = s.charAt(r);
            if (s.charAt(r - 1) == c)
                cnt++;
            else {
                cnt = 1;
                last = r;
            }
            if (cnt > 2 && l < last)
                l = last;
            while (cnt > 2) {
                l++;
                cnt--;
            }
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                res = s.substring(l, r + 1);
            }
        }
        return res;
    }
}
