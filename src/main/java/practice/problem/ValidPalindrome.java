package practice.problem;

// 125. Valid Palindrome
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.equals(""))
            return true;
        int left = 0, right = s.length() - 1;
        char head, tail;
        while (left <= right) {
            head = s.charAt(left);
            tail = s.charAt(right);
            if (!Character.isLetterOrDigit(head))
                left++;
            else if (!Character.isLetterOrDigit(tail))
                right--;
            else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
