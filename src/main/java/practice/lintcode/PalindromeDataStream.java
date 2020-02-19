package practice.lintcode;

// 958. Palindrome Data Stream
public class PalindromeDataStream {
    /**
     * @param s: The data stream
     * @return: Return the judgement stream
     */
    public int[] getStream(String s) {
        // Write your code here
        int[] ans = new int[s.length()];
        int[] chars = new int[26];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars[c - 'a'] % 2 == 1) {
                cnt--;
                chars[c - 'a']++;
            } else {
                cnt++;
                chars[c - 'a']++;
            }
            if (cnt > 1)
                ans[i] = 0;
            else
                ans[i] = 1;
        }
        return ans;
    }
}
