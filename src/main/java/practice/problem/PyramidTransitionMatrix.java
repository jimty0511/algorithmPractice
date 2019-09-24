package practice.problem;

import java.util.*;

// 756. Pyramid Transition Matrix
public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String pre = s.substring(0, 2);
            map.putIfAbsent(pre, new HashSet<>());
            map.get(pre).add(s.charAt(2));
        }
        return dfs(bottom, "", map, 1);
    }

    private boolean dfs(String row, String nextRow, Map<String, Set<Character>> allowed, int i) {
        if (row.length() == 1)
            return true;
        if (nextRow.length() + 1 == row.length())
            return dfs(nextRow, "", allowed, 1);
        for (Character c : allowed.getOrDefault(row.substring(i - 1, i + 1), new HashSet<>())) {
            if (dfs(row, nextRow + c, allowed, i + 1))
                return true;
        }
        return false;
    }
}
