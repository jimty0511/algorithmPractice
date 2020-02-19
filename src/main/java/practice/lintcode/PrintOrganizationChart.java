package practice.lintcode;

import java.util.*;

// 997. Print Organization Chart
public class PrintOrganizationChart {
    /**
     * @param relationship: the relationship
     * @return: the organization chart
     */
    public List<String> getOrganization(List<List<String>> relationship) {
        // Write your code here
        Map<String, List<String[]>> map = new HashMap<>();
        String ceo = null;
        for (List<String> r : relationship) {
            StringBuilder sb = new StringBuilder();
            if (r.get(1).equals("NULL"))
                ceo = r.get(0);
            sb.append(r.get(0)).append(" (").append(r.get(2)).append(") ").append(r.get(3));
            map.putIfAbsent(r.get(1), new ArrayList<>());
            String[] cur = new String[]{r.get(0), sb.toString()};
            map.get(r.get(1)).add(cur);
        }
        for (List<String[]> val : map.values()) {
            Collections.sort(val, (a, b) -> a[0].compareTo(b[0]));
        }
        List<String> res = new ArrayList<>();
        res.add(map.get("NULL").get(0)[1]);
        helper(1, ceo, map, res);
        return res;
    }

    private void helper(int level, String position, Map<String, List<String[]>> map, List<String> res) {
        if (!map.containsKey(position))
            return;
        List<String[]> cur = map.get(position);
        for (String[] next : cur) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++)
                sb.append("-");
            sb.append(next[1]);
            res.add(sb.toString());
            helper(level + 1, next[0], map, res);
        }
    }
}
