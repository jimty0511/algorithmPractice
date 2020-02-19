package practice.problem;

import java.util.*;

// 425. Word Squares
public class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String w : words) {
            for (int i = 1; i < w.length(); i++) {
                String pre = w.substring(0, i);
                map.putIfAbsent(pre, new HashSet<>());
                map.get(pre).add(w);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String w : words) {
            List<String> tmp = new ArrayList<>();
            tmp.add(w);
            helper(tmp, 1, words[0].length(), map, res);
        }
        return res;
    }

    private void helper(List<String> tmp, int pos, int len, Map<String, Set<String>> map, List<List<String>> res) {
        if (pos == len) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : tmp) {
            sb.append(s.charAt(pos));
        }
        if (!map.containsKey(sb.toString()))
            return;
        for (String next : map.get(sb.toString())) {
            tmp.add(next);
            helper(tmp, pos + 1, len, map, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
