package practice.problem;

// 1156. Swap For Longest Repeated Character Substring
public class SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        if (text.isEmpty())
            return 0;
        int[] slidingCnt = new int[26], totalCnt = new int[26];
        for (char c : text.toCharArray())
            totalCnt[c - 'a']++;
        int start = 0, maxCnt = 0, maxLen = 0;
        for (int end = 0; end < text.length(); end++) {
            maxCnt = Math.max(maxCnt, ++slidingCnt[text.charAt(end) - 'a']);
            while (end - start + 1 - maxCnt > 1 || end - start + 1 > totalCnt[text.charAt(start) - 'a']) {
                slidingCnt[text.charAt(start) - 'a']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
