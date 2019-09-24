package practice.problem;

public class MinLengthForMergedString {
    public int minMergeStrings(String a, String b) {
        int common = 0;
        common = getCommonSubstring(a, b);
        String revA = new StringBuilder(a).reverse().toString();
        String revB = new StringBuilder(b).reverse().toString();
        common = Math.max(common, getCommonSubstring(revA, b));
        common = Math.max(common, getCommonSubstring(a, revB));
        return a.length() + b.length() - common;
    }

    private int getCommonSubstring(String a, String b) {
        int res = 0;
        for (int i = a.length() - 2; i >= 0; i--) {
            String str = a.substring(i);
            if (b.startsWith(str))
                res = Math.max(res, str.length());
        }
        return res;
    }
}
