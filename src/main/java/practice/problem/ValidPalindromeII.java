package practice.problem;

// 680. Valid Palindrome II
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return helper(s, left, right - 1) || helper(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean helper(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
