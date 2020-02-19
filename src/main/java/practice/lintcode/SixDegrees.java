package practice.lintcode;

import practice.domain.UndirectedGraphNode;

import java.util.*;

// 531. Six Degrees
public class SixDegrees {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // write your code here
        if (s.equals(t))
            return 0;
        Map<UndirectedGraphNode, Integer> steps = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(s);
        steps.put(s, 0);
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            int step = steps.get(cur);
            if (cur.equals(t))
                return step;
            for (int i = 0; i < cur.neighbors.size(); i++) {
                if (steps.containsKey(cur.neighbors.get(i)))
                    continue;
                steps.put(cur.neighbors.get(i), step + 1);
                q.offer(cur.neighbors.get(i));
            }
        }
        return -1;
    }
}
