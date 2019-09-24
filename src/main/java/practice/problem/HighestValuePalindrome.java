package practice.problem;

// Hackerrank
public class HighestValuePalindrome {
    public String highestValuePalindrome(String s, int n, int k) {
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                chars[l] = chars[r] = (char) Math.max(s.charAt(l), s.charAt(r));
                k--;
            }
            l++;
            r--;
        }
        if (k < 0)
            return "-1";
        l = 0;
        r = s.length() - 1;
        while (l <= r) {
            if (l == r) {
                if (k > 0)
                    chars[l] = '9';
            }
            if (chars[l] < '9') {
                if (k >= 2 && chars[l] == s.charAt(l) && chars[r] == s.charAt(r)) {
                    k -= 2;
                    chars[l] = chars[r] = '9';
                } else if (k >= 1 && (chars[l] != s.charAt(l) || chars[r] != s.charAt(r))) {
                    k--;
                    chars[l] = chars[r] = '9';
                }
            }
            l++;
            r--;
        }
        return new String(chars);
    }
}
