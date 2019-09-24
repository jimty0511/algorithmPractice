package practice.problem;

// 564. Find the Closest Palindrome
public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        long nVal = Long.parseLong(n);
        if (nVal <= 10 || (nVal % 10 == 0 && n.charAt(0) == '1' && Integer.valueOf(n.substring(1)) == 0))
            return String.valueOf(nVal - 1);
        if (nVal == 11 || (nVal % 10 == 1 && n.charAt(0) == '1' && n.charAt(n.length() - 1) == '1' && Integer.valueOf(n.substring(1, n.length() - 1)) == 0))
            return String.valueOf(nVal - 2);
        boolean allNine = false;
        for (char c : n.toCharArray()) {
            if (c != '9') {
                allNine = true;
                break;
            }
        }
        if (!allNine && nVal >= 99)
            return String.valueOf(nVal + 2);
        String palindromeRoot = n.substring(0, (n.length() + 1) / 2);
        int valPalindromeRoot = Integer.valueOf(palindromeRoot);
        long tmpEqual = Long.parseLong(toPalindrome(valPalindromeRoot, n.length() % 2 == 0));
        long tmpBigger = Long.parseLong(toPalindrome(valPalindromeRoot + 1, n.length() % 2 == 0));
        long tmpSmaller = Long.parseLong(toPalindrome(valPalindromeRoot - 1, n.length() % 2 == 0));
        long distEqual = Math.abs(nVal - tmpEqual);
        long distBigger = Math.abs(nVal - tmpBigger);
        long distSmaller = Math.abs(nVal - tmpSmaller);
        long distMin = 0L;
        if (distEqual == 0) {
            distMin = Math.min(distBigger, distSmaller);
        } else {
            distMin = Math.min(distEqual, Math.min(distBigger, distSmaller));
        }
        if (distMin == distSmaller) {
            return String.valueOf(tmpSmaller);
        } else if (distMin == distEqual) {
            return String.valueOf(tmpEqual);
        } else {
            return String.valueOf(tmpBigger);
        }
    }

    private String toPalindrome(int num, boolean isEven) {
        String str = String.valueOf(num);
        if (isEven) {
            return str + (new StringBuilder(str).reverse()).toString();
        } else {
            return str + (new StringBuilder(str).reverse().deleteCharAt(0)).toString();
        }
    }
}
