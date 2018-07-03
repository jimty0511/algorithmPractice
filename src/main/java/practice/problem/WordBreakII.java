package practice.problem;

import java.util.*;

// 140. Word Break II
public class WordBreakII {

    Map<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, dict, 0);
    }

    private List<String> helper(String s, Set<String> dict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end))) {
                List<String> list = helper(s, dict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
