package practice.lintcode;

// 1560. MinimumString
public class MinimumString {
    /**
     * @param s: the string
     * @param k: the max time to remove characters
     * @return: Please output the new string with the smallest lexicographic order.
     */
    public String MinimumString(char[] s, int k) {
        // Write your code here
        if (s == null || s.length == 0 || s.length <= k)
            return "";
        int idx = 0;
        char[] res = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            while (idx > 0 && k > 0 && s[i] < res[idx - 1]) {
                idx--;
                k--;
            }
            res[idx++] = s[i];
        }
        return new String(res, 0, idx - k);
    }
}
