package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 132. Palindrome Partitioning II
public class PalindromePartitioningII {
    int minCut = Integer.MAX_VALUE;

//    public int minCut(String s) {
//        if (s == null || s.length() == 0)
//            return 0;
//        minCutHelper(s, 0, new ArrayList<>());
//        return minCut;
//    }
//
//    public void minCutHelper(String s, int start, List<String> list) {
//        if (start == s.length()) {
//            minCut = Math.min(minCut, list.size() - 1);
//        } else {
//            for (int i = start; i < s.length(); i++) {
//                if (isPalindrome(s, start, i)) {
//                    list.add(s.substring(start, i + 1));
//                    minCutHelper(s, i + 1, list);
//                    list.remove(list.size() - 1);
//                }
//            }
//        }
//    }
//
//    public boolean isPalindrome(String s, int low, int high) {
//        while (low < high) {
//            if (s.charAt(low++) != s.charAt(high--))
//                return false;
//        }
//        return true;
//    }

    public int minCutDp(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (chars[j] == chars[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

    public int minCutDpTwo(String s) {
        if (s == null)
            return 0;
        int i, j, n = s.length();
        int cut[] = new int[n];
        boolean[][] dp = new boolean[n][n];
        for (i = 0; i < n; i++) {
            cut[i] = i;
            for (j = 0; j <= i; j++) {
                if (j == i) {
                    dp[j][i] = true;
                } else {
                    if (s.charAt(i) != s.charAt(j)) {
                        continue;
                    }
                    if (j == i - 1) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i]) {
                    if (j == 0) {
                        cut[i] = 0;
                    } else {
                        cut[i] = Math.min(cut[j - 1] + 1, cut[i]);
                    }
                }
            }
        }
        return cut[n - 1];
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int[] cut = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cut[i] = i - 1;
        }
        boolean[][] mat = paMat(s);
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (mat[j][i - 1]) {
                    cut[i] = Math.min(cut[i], 1 + cut[j]);
                }
            }
        }
        return cut[len];
    }

    private boolean[][] paMat(String s) {
        int len = s.length();
        boolean[][] mat = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (j == i) {
                    mat[i][i] = true;
                } else if (j == i + 1) {
                    mat[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    mat[i][j] = (s.charAt(i) == s.charAt(j) && mat[i + 1][j - 1]);
                }
            }
        }
        return mat;
    }
}
