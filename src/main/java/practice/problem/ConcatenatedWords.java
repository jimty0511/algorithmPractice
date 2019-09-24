package practice.problem;


import java.util.*;

// 472. Concatenated Words
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            if (helper(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        return result;
    }

    private boolean helper(String word, Set<String> dict) {
        if (dict.isEmpty())
            return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j])
                    continue;
                if (dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public List<String> findAllConcatenatedWordsInADictTwo(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<String> res = new ArrayList<>();
        for (String w : words) {
            int n = w.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                if (!dp[i])
                    continue;
                for (int j = i + 1; j <= n; j++) {
                    if (j - i < n && set.contains(w.substring(i, j)))
                        dp[j] = true;
                }
                if (dp[n]) {
                    res.add(w);
                    break;
                }
            }
        }
        return res;
    }
}

