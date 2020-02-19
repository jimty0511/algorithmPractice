package practice.problem;

import java.util.*;

// 1203. Sort Items by Groups Respecting Dependencies
public class SortItemsByGroupsRespectingDependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, Set<Integer>> itemGraph = new HashMap<>(), groupGraph = new HashMap<>();
        Map<Integer, Integer> itemInDegree = new HashMap<>(), groupInDegree = new HashMap<>();
        for (int i = 0; i < n; i++)
            itemGraph.put(i, new HashSet<>());
        for (int g : group)
            groupGraph.putIfAbsent(g, new HashSet<>());
        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> list = beforeItems.get(i);
            if (list.size() != 0) {
                for (int before : list) {
                    itemGraph.get(before).add(i);
                    itemInDegree.put(i, itemInDegree.getOrDefault(i, 0) + 1);
                    int groupBefore = group[before];
                    int groupI = group[i];
                    if (groupI != groupBefore && groupGraph.get(groupBefore).add(groupI))
                        groupInDegree.put(groupI, groupInDegree.getOrDefault(groupI, 0) + 1);
                }
            }
        }
        List<Integer> itemOrder = sort(itemGraph, itemInDegree, n);
        List<Integer> groupOrder = sort(groupGraph, groupInDegree, groupGraph.size());
        if (itemOrder.size() == 0 || groupOrder.size() == 0)
            return new int[0];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int item : itemOrder) {
            int g = group[item];
            map.putIfAbsent(g, new ArrayList<>());
            map.get(g).add(item);
        }
        int[] res = new int[n];
        int i = 0;
        for (int g : groupOrder) {
            for (int item : map.get(g)) {
                res[i++] = item;
            }
        }
        return res;
    }

    private List<Integer> sort(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> inDegree, int cnt) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int key : graph.keySet()) {
            if (inDegree.getOrDefault(key, 0) == 0)
                q.offer(key);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt--;
            res.add(cur);
            for (int next : graph.get(cur)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0)
                    q.offer(next);
            }
        }
        return cnt == 0 ? res : new ArrayList<>();
    }
}
