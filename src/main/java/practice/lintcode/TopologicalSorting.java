package practice.lintcode;

import java.util.*;

// 127. Topological Sorting
public class TopologicalSorting {

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.putIfAbsent(node, 0);
                map.put(neighbor, map.getOrDefault(neighbor, 0) + 1);
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<>();
        for (DirectedGraphNode key : map.keySet()) {
            if (map.get(key) == 0)
                q.offer(key);
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            res.add(node);
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    q.offer(n);
                }
            }
        }
        return res;
    }
}
