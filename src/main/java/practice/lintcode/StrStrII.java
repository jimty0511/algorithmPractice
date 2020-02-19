package practice.lintcode;

// 594. strStr II
public class StrStrII {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public int strStr2(String source, String target) {
        // write your code here
        if (target == null || source == null || source.length() < target.length())
            return -1;
        int m = target.length();
        if (m == 0 && source != null)
            return 0;
        int n = source.length();
        if (n == 0)
            return 0;
        int mod = Integer.MAX_VALUE / 33;
        int hashTarget = 0;
        for (int i = 0; i < m; i++) {
            hashTarget = (hashTarget * 33 + target.charAt(i) - 'a') % mod;
            if (hashTarget < 0)
                hashTarget += mod;
        }
        int removedValue = 1;
        for (int i = 0; i < m - 1; i++)
            removedValue = removedValue * 33 % mod;
        int curVal = 0;
        for (int i = 0; i < n; i++) {
            if (i >= m) {
                curVal = (curVal - removedValue * (source.charAt(i - m) - 'a')) % mod;
            }
            curVal = (curVal * 33 + source.charAt(i) - 'a') % mod;
            if (curVal < 0)
                curVal += mod;
            if (i >= m - 1 && curVal == hashTarget) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
