package practice.lintcode;

import practice.domain.UndirectedGraphNode;

import java.util.*;

// 431. Connected Component in Undirected Graph
public class ConnectedComponentInUndirectedGraph {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        Set<UndirectedGraphNode> visited = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (UndirectedGraphNode n : nodes) {
            if (visited.add(n))
                bfs(n, visited, res);
        }
        return res;
    }

    private void bfs(UndirectedGraphNode node, Set<UndirectedGraphNode> visited, List<List<Integer>> res) {
        List<Integer> row = new ArrayList<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            row.add(n.label);
            for (UndirectedGraphNode next : n.neighbors) {
                if (visited.add(next))
                    q.offer(next);
            }
        }
        Collections.sort(row);
        res.add(row);
    }

    public List<List<Integer>> connectedSetUf(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            parent.put(n.label, n.label);
        }
        for (UndirectedGraphNode n : nodes) {
            for (UndirectedGraphNode next : n.neighbors) {
                union(parent, n.label, next.label);
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : parent.keySet()) {
            map.putIfAbsent(find(parent, i), new ArrayList<>());
            map.get(find(parent, i)).add(i);
        }
        for (List<Integer> v : map.values()) {
            Collections.sort(v);
            res.add(v);
        }
        return res;
    }

    private int find(Map<Integer, Integer> parent, int a) {
        while (a != parent.get(a)) {
            a = parent.get(a);
        }
        return a;
    }

    private void union(Map<Integer, Integer> parent, int a, int b) {
        int aP = find(parent, a);
        int bP = find(parent, b);
        if (aP != bP)
            parent.put(aP, bP);
    }
}
