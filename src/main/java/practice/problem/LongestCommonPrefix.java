package practice.problem;

// 14. Longest Common Prefix
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }
        return pre;
    }

    public String longestCommonPrefixTwo(String[] strs) {
        if (strs == null)
            return null;
        if (strs.length == 0)
            return "";
        String first = strs[0], last = strs[0];
        for (String str : strs) {
            if (str.compareTo(first) < 0)
                first = str;
            if (str.compareTo(last) > 0)
                last = str;
        }
        int i = 0, len = Math.min(first.length(), last.length());
        while (i < len && first.charAt(i) == last.charAt(i))
            i++;
        return first.substring(0, i);
    }

    public String longestCommonPrefixBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (helper(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean helper(String[] strs, int middle) {
        String str1 = strs[0].substring(0, middle);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }
}
