package practice.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 399. Evaluate Division
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        int i = 0;
        for (String[] str : equations) {
            insertPairs(map, str[0], str[1], values[i]);
            insertPairs(map, str[1], str[0], 1.0 / values[i]);
            i++;
        }
        double[] result = new double[queries.length];
        i = 0;
        for (String[] q : queries) {
            Double resObj = handleQuery(q[0], q[1], map, new HashSet<>());
            result[i++] = resObj != null ? resObj : -1.0;
        }
        return result;
    }

    private void insertPairs(Map<String, Map<String, Double>> map, String num, String denom, Double value) {
        Map<String, Double> denomMap = map.get(num);
        if (denomMap == null) {
            denomMap = new HashMap<>();
            map.put(num, denomMap);
        }
        denomMap.put(denom, value);
    }

    private Double handleQuery(String num, String denom, Map<String, Map<String, Double>> map, Set<String> visited) {
        String dupeKey = num + ":" + denom;
        if (visited.contains(dupeKey))
            return null;
        if (!map.containsKey(num) || !map.containsKey(denom))
            return null;
        if (num.equals(denom))
            return 1.0;

        Map<String, Double> denomMap = map.get(num);
        visited.add(dupeKey);
        for (String key : denomMap.keySet()) {
            Double res = handleQuery(key, denom, map, visited);
            if (res != null) {
                return denomMap.get(key) * res;
            }
        }
        visited.remove(dupeKey);
        return null;
    }
}
