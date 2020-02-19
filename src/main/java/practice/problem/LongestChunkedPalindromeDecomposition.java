package practice.problem;

// 1147. Longest Chunked Palindrome Decomposition
public class LongestChunkedPalindromeDecomposition {
    public int longestDecomposition(String text) {
        int res = 0, n = text.length();
        for (int i = 0, j = n - 1; i <= j; ) {
            boolean found = false;
            for (int len = 1; i + len - 1 < j - len + 1; len++) {
                if (text.substring(i, i + len).equals(text.substring(j - len + 1, j + 1))) {
                    i = i + len;
                    j = j - len;
                    res += 2;
                    found = true;
                    break;
                }
            }
            if (!found) {
                res += 1;
                break;
            }
        }
        return res;
    }

    public int longestDecompositionRecursion(String text) {
        for (int i = 1; i <= text.length() / 2; i++) {
            if (text.substring(0, i).equals(text.substring(text.length() - i)))
                return 2 + longestDecomposition(text.substring(i, text.length() - i));
        }
        return text.length() == 0 ? 0 : 1;
    }
}
