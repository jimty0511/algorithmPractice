package practice.problem;

import java.util.*;

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

    public double[] calcEquationGraph(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<String>> pairs = new HashMap<>();
        Map<String, ArrayList<Double>> valuesPair = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<>());
                valuesPair.put(equation[0], new ArrayList<>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<>());
                valuesPair.put(equation[1], new ArrayList<>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1 / values[i]);
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<>(), 1.0);
            if (result[i] == 0.0)
                result[i] = -1.0;
        }
        return result;
    }

    private double dfs(String start, String end, Map<String, ArrayList<String>> pairs,
                       Map<String, ArrayList<Double>> values, Set<String> set, double value) {
        if (set.contains(start))
            return 0.0;
        if (!pairs.containsKey(start))
            return 0.0;
        if (start.equals(end))
            return value;
        set.add(start);
        List<String> strList = pairs.get(start);
        List<Double> valueList = values.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, values, set, value * valueList.get(i));
            if (tmp != 0.0)
                break;
        }
        set.remove(start);
        return tmp;
    }
}
