package practice.problem;

import java.util.*;

// https://github.com/allaboutjst/airbnb
public class PreferenceList {
    public List<Integer> getPreference(List<List<Integer>> preferences) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Set<Integer>> adjs = new HashMap<>();
        for (List<Integer> list : preferences) {
            for (int i = 0; i < list.size() - 1; i++) {
                int from = list.get(i), to = list.get(i + 1);
                inDegree.putIfAbsent(from, 0);
                inDegree.putIfAbsent(to, 0);
                adjs.putIfAbsent(from, new HashSet<>());
                adjs.putIfAbsent(to, new HashSet<>());
                adjs.get(from).add(to);
                inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int k : inDegree.keySet()) {
            if (inDegree.get(k) == 0)
                q.offer(k);
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int id = q.poll();
            res.add(id);
            Set<Integer> neighbors = adjs.get(id);
            for (int next : neighbors) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0)
                    q.offer(next);
            }
        }
        return res;
    }
}
