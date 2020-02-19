package practice.lcdesign;

import java.util.*;

// 519. Consistent Hashing
// Chapter 3
public class ConsistentHashing {

    class Node {
        int start;
        int end;
        int id;

        public Node(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
    }

    public List<List<Integer>> consistentHashing(int n) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1)
            return res;
        else if (n == 1) {
            res.add(Arrays.asList(0, 359, 1));
            return res;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if ((b.end - b.start) == (a.end - a.start))
                    return a.id - b.id;
                return (b.end - b.start) - (a.end - a.start);
            }
        });
        pq.offer(new Node(0, 359, 1));
        for (int i = 2; i <= n; i++) {
            Node node = pq.poll();
            int mid = (node.end + node.start) / 2;
            pq.offer(new Node(node.start, mid, node.id));
            pq.offer(new Node(mid + 1, node.end, i));
        }
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            res.add(Arrays.asList(node.start, node.end, node.id));
        }
        return res;
    }

    public List<List<Integer>> consistentHashingTwo(int n) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> (b.get(1) - b.get(0)) == (a.get(1) - a.get(0)) ? a.get(2) - b.get(2) : (b.get(1) - b.get(0)) - (a.get(1) - a.get(0)));
        pq.offer(Arrays.asList(0, 359, 1));
        for (int i = 2; i <= n; i++) {
            List<Integer> cur = pq.poll();
            int start = cur.get(0);
            int end = cur.get(1);
            int idx = cur.get(2);
            int mid = (start + end) / 2;
            pq.offer(Arrays.asList(start, mid, idx));
            pq.offer(Arrays.asList(mid + 1, end, i));
        }
        List<List<Integer>> res = new ArrayList<>(pq);
        Collections.sort(res, (a, b) -> a.get(0) - b.get(0));
        return res;
    }
}
