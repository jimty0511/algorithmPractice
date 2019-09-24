package practice.problem;

import java.util.*;

// 139. Word Break
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int len = w.length();
                if (len <= i) {
                    if (dp[i - len]) {
                        if (s.substring(i - len, i).equals(w)) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreakTwo(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return false;
        int max = Integer.MIN_VALUE;
        for (String w : wordDict)
            max = Math.max(max, w.length());
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= max && j <= i; j++) {
                if (dp[i - j] && wordDict.contains(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreakTwoBfs(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.offer(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.offer(end);
                        if (end == s.length())
                            return true;
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    public boolean wordBreakThree(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
