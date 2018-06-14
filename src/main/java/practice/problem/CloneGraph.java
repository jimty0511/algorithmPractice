package practice.problem;

import practice.domain.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// 133. Clone Graph
public class CloneGraph {
    Map<Integer, UndirectedGraphNode> unDirectedGraphNodeMap = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (unDirectedGraphNodeMap.containsKey(node.label)) {
            return unDirectedGraphNodeMap.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        unDirectedGraphNodeMap.put(node.label, clone);
        for (UndirectedGraphNode neighbour : node.neighbors) {
            clone.neighbors.add(clone(neighbour));
        }
        return clone;
    }

    public UndirectedGraphNode cloneGraphBfs(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(newNode.label, newNode);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = ((LinkedList<UndirectedGraphNode>) queue).pop();
            for (UndirectedGraphNode neighbour : n.neighbors) {
                if (!map.containsKey(neighbour.label)) {
                    map.put(neighbour.label, new UndirectedGraphNode(neighbour.label));
                    queue.offer(neighbour);
                }
                map.get(n.label).neighbors.add(map.get(neighbour.label));
            }
        }
        return newNode;
    }
}
