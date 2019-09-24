package practice.problem;

import java.util.*;

public class Wizards {

    class Wizard implements Comparable<Wizard> {

        int id;
        int dist;

        public Wizard(int v) {
            this.id = v;
            this.dist = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Wizard that) {
            return this.dist - that.dist;
        }
    }

    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
        if (wizards == null || wizards.size() == 0)
            return null;
        int n = wizards.size();
        int[] parents = new int[n];
        Map<Integer, Wizard> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            map.put(i, new Wizard(i));
        }
        map.get(source).dist = 0;
        PriorityQueue<Wizard> pq = new PriorityQueue<>(n);
        pq.offer(map.get(source));
        while (!pq.isEmpty()) {
            Wizard curr = pq.poll();
            List<Integer> neighbors = wizards.get(curr.id);
            for (int neighbor : neighbors) {
                Wizard next = map.get(neighbor);
                int weight = (int) Math.pow(next.id - curr.id, 2);
                if (curr.dist + weight < next.dist) {
                    parents[next.id] = curr.id;
                    pq.remove(next);
                    next.dist = curr.dist + weight;
                    pq.offer(next);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int t = target;
        while (t != source) {
            res.add(t);
            t = parents[t];
        }
        res.add(source);
        Collections.reverse(res);
        return res;
    }
}
