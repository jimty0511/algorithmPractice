package practice.lintcode;

import java.util.*;

// 1757. Collecting diamonds
public class CollectingDiamonds {

    int res = Integer.MIN_VALUE;
    Set<String> visitedStr = new HashSet<>();

    /**
     * @param n:   the number of cities
     * @param k:   the number of days
     * @param num: the number of diamonds in the ith city
     * @param mp:  the road of all the cities
     * @return: how many diamonds he can collect
     */
    public int getCount(int n, int k, int[] num, int[][] mp) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] m : mp) {
            graph.putIfAbsent(m[0] - 1, new HashSet<>());
            graph.get(m[0] - 1).add(m[1] - 1);
            graph.putIfAbsent(m[1] - 1, new HashSet<>());
            graph.get(m[1] - 1).add(m[0] - 1);
        }
        int[] visited = new int[n];
        helper(-1, 0, k, graph, num, visited, 0);
        return res;
    }

    private void helper(int prevCity, int curCity, int daysLeft, Map<Integer, Set<Integer>> graph, int[] num, int[] visited, int curSum) {
        if (visitedStr.contains(visited))
            return;
        if (visited[curCity] == 0)
            curSum += num[curCity];
        if (daysLeft == 0) {
            res = Math.max(curSum, res);
            return;
        }
        Set<Integer> neighbours = graph.get(curCity);
        visited[curCity]++;
        for (int next : neighbours) {
            if (next == prevCity && visited[curCity] >= 2)
                continue;
            helper(curCity, next, daysLeft - 1, graph, num, visited, curSum);
        }
        visited[curCity]--;
        visitedStr.add(Arrays.toString(visited));
    }

    class Node {
        boolean[] visited;
        Set<Integer> sums;

        public Node(Set<Integer> sums, boolean[] visited) {
            this.visited = visited;
            this.sums = sums;
        }
    }

    public int getCountDp(int n, int k, int[] num, int[][] mp) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] m : mp) {
            graph.putIfAbsent(m[0] - 1, new HashSet<>());
            graph.get(m[0] - 1).add(m[1] - 1);
            graph.putIfAbsent(m[1] - 1, new HashSet<>());
            graph.get(m[1] - 1).add(m[0] - 1);
        }
        int[][] dp = new int[n][2];
        dp[0] = new int[]{num[0], 1};
        for (int day = 1; day <= k; day++) {
            int[][] tmp = new int[n][2];
            for (int i = 0; i < n; i++) {
                int[] cur = dp[i];
                int curSum = cur[0];
                int visited = cur[1];
                if (cur[0] > 0) {
                    Set<Integer> neighbours = graph.get(i);
                    for (int next : neighbours) {
//                        if (matrix[i][next]) {
                        int newSum = curSum;
                        int newVisited = visited;
                        if ((visited & 1 << next) == 0) {
                            newSum += num[next];
                        }
                        if (tmp[next][0] != 0 && tmp[next][0] > newSum)
                            continue;
                        newVisited |= 1 << next;
                        tmp[next] = new int[]{newSum, newVisited};
//                        }
                    }
                }
            }
            dp = tmp;
        }
        int res = Integer.MIN_VALUE;
        for (int d[] : dp)
            res = Math.max(d[0], res);
        return res;
    }

    class NewNode {
        boolean[] visited;
        int sum;

        public NewNode(int sum, boolean[] visited) {
            this.visited = visited;
            this.sum = sum;
        }
    }

    public int getCountDpTwo(int n, int k, int[] num, int[][] mp) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] m : mp) {
            graph.putIfAbsent(m[0], new HashSet<>());
            graph.get(m[0]).add(m[1]);
            graph.putIfAbsent(m[1], new HashSet<>());
            graph.get(m[1]).add(m[0]);
        }
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Map<Integer, NewNode> dp = new HashMap<>();
        dp.put(1, new NewNode(num[0], visited));
        for (int day = 1; day <= k; day++) {
            Map<Integer, NewNode> tmp = new HashMap<>();
            Set<Integer> cities = dp.keySet();
            for (int i : cities) {
                NewNode cur = dp.get(i);
                int curSum = cur.sum;
                boolean[] curVisited = cur.visited;
                Set<Integer> neighbours = graph.get(i);
                for (int next : neighbours) {
                    int newSum = curSum;
                    boolean[] newVisited = Arrays.copyOf(curVisited, n + 1);
                    if (!newVisited[next]) {
                        newSum += num[next - 1];
                    }
                    newVisited[next] = true;
                    if (!tmp.containsKey(next) || tmp.get(next).sum < newSum)
                        tmp.put(next, new NewNode(newSum, newVisited));
                }
            }
            dp = tmp;
        }
        int res = Integer.MIN_VALUE;
        for (NewNode d : dp.values()) {
            res = Math.max(d.sum, res);
        }
        return res;
    }

    public int getCountDpThree(int n, int k, int[] num, int[][] mp) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] m : mp) {
            graph.putIfAbsent(m[0] - 1, new HashSet<>());
            graph.get(m[0] - 1).add(m[1] - 1);
            graph.putIfAbsent(m[1] - 1, new HashSet<>());
            graph.get(m[1] - 1).add(m[0] - 1);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Map<Integer, Node> dp = new HashMap<>();
        dp.put(0, new Node(new HashSet<>(Arrays.asList(num[0])), visited));
        for (int day = 1; day <= k; day++) {
            Map<Integer, Node> tmp = new HashMap<>();
            Set<Integer> cities = dp.keySet();
            for (int i : cities) {
                Node cur = dp.get(i);
                Set<Integer> curSums = cur.sums;
                boolean[] curVisited = cur.visited;
                Set<Integer> neighbours = graph.get(i);
                for (int next : neighbours) {
                    for (int curSum : curSums) {
                        int newSum = curSum;
                        Set<Integer> nextSums;
                        if (tmp.containsKey(next))
                            nextSums = tmp.get(next).sums;
                        else
                            nextSums = new HashSet<>();
                        boolean[] newVisited = Arrays.copyOf(curVisited, n);
                        if (!newVisited[next]) {
                            newSum += num[next];
                        }
                        nextSums.add(newSum);
                        newVisited[next] = true;
                        tmp.put(next, new Node(nextSums, newVisited));
                    }
                }
            }
            dp = tmp;
        }
        int res = Integer.MIN_VALUE;
        for (Node d : dp.values()) {
            for (int val : d.sums) {
                res = Math.max(val, res);
            }
        }
        return res;
    }

    class NodeWPre {
        int[] visited;
        int sum;
        int pre;
//        int visitedNodes;

        public NodeWPre(int sum, int[] visited, int pre) {
            this.visited = visited;
            this.sum = sum;
            this.pre = pre;
//            this.visitedNodes = visitedNodes;
        }
    }

    public int getCountDpFour(int n, int k, int[] num, int[][] mp) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] m : mp) {
            graph.putIfAbsent(m[0] - 1, new HashSet<>());
            graph.get(m[0] - 1).add(m[1] - 1);
            graph.putIfAbsent(m[1] - 1, new HashSet<>());
            graph.get(m[1] - 1).add(m[0] - 1);
        }
        int[] visited = new int[n];
        visited[0] = 1;
        Map<Integer, List<NodeWPre>> dp = new HashMap<>();
        dp.put(0, Arrays.asList(new NodeWPre(num[0], visited, -1)));
        for (int day = 1; day <= k; day++) {
            Map<Integer, List<NodeWPre>> tmp = new HashMap<>();
            Set<Integer> cities = dp.keySet();
            for (int curCity : cities) {
                List<NodeWPre> allPaths = dp.get(curCity);
                for (NodeWPre curNode : allPaths) {
                    int curSum = curNode.sum;
                    int[] curVisited = curNode.visited;
                    int preCity = curNode.pre;
//                    int curVisitedNodes = curNode.visitedNodes;
                    Set<Integer> neighbours = graph.get(curCity);
                    for (int next : neighbours) {
                        if (next == preCity && curVisited[curCity] >= 2)
                            continue;
                        int nextSum = curSum;
//                        int nextVisitedNodes = curVisitedNodes;
                        int[] nextVisited = Arrays.copyOf(curVisited, curVisited.length);
                        if (nextVisited[next] == 0) {
                            nextSum += num[next];
//                            nextVisitedNodes++;
                        }
                        nextVisited[next]++;
                        tmp.putIfAbsent(next, new ArrayList<>());
                        tmp.get(next).add(new NodeWPre(nextSum, nextVisited, curCity));
                    }
                }
            }
            dp = tmp;
        }
        int res = Integer.MIN_VALUE, mostVisited = 0;
        NodeWPre finalNode = null;
        for (List<NodeWPre> nodes : dp.values()) {
            for (NodeWPre node : nodes) {
                if (node.sum > res) {
                    res = node.sum;
                    finalNode = node;
                }
            }
        }
        return res;
    }

    class NodePath {
        int[] visited;
        int visitedNodes;

        public NodePath(int[] visited, int visitedNodes) {
            this.visited = visited;
            this.visitedNodes = visitedNodes;
        }
    }

    public int getCountDpFive(int n, int k, int[] num, int[][] mp) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] m : mp) {
            graph.putIfAbsent(m[0] - 1, new HashSet<>());
            graph.get(m[0] - 1).add(m[1] - 1);
            graph.putIfAbsent(m[1] - 1, new HashSet<>());
            graph.get(m[1] - 1).add(m[0] - 1);
        }
        int[] visited = new int[n];
        visited[0] = 1;
        Map<Integer, Map<String, NodePath>> dp = new HashMap<>();
        String visitedPath = Arrays.toString(visited);
        dp.put(0, new HashMap<>());
        dp.get(0).put(visitedPath, new NodePath(visited, 1));
        for (int day = 1; day <= k; day++) {
            Map<Integer, Map<String, NodePath>> tmp = new HashMap<>();
            Set<Integer> cities = dp.keySet();
            for (int curCity : cities) {
                Map<String, NodePath> allPaths = dp.get(curCity);
                for (String path : allPaths.keySet()) {
                    NodePath curNode = allPaths.get(path);
                    int[] curVisited = curNode.visited;
                    int curVisitedNodes = curNode.visitedNodes;
                    Set<Integer> neighbours = graph.get(curCity);
                    for (int next : neighbours) {
                        int nextVisitedNodes = curVisitedNodes;
                        int[] nextVisited = Arrays.copyOf(curVisited, curVisited.length);
                        if (nextVisited[next] == 0) {
                            nextVisitedNodes++;
                        }
                        nextVisited[next]++;
                        tmp.putIfAbsent(next, new HashMap<>());
                        tmp.get(next).put(Arrays.toString(nextVisited), new NodePath(nextVisited, nextVisitedNodes));
                    }
                }
            }
            dp = tmp;
        }
        int res = 0, mostVisited = 0;
        int[] finalVisited = null;
        for (Map<String, NodePath> map : dp.values()) {
            for (NodePath node : map.values()) {
                if (node.visitedNodes > mostVisited) {
                    mostVisited = node.visitedNodes;
                    finalVisited = node.visited;
                }
            }
        }
        for (int i : finalVisited) {
            if (i != 0)
                res += num[0];
        }
        return res;
    }

    public int getCountPath(int n, int k, int[] num, int[][] mp) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] m : mp) {
            graph.putIfAbsent(m[0], new HashSet<>());
            graph.get(m[0]).add(m[1]);
            graph.putIfAbsent(m[1], new HashSet<>());
            graph.get(m[1]).add(m[0]);
        }
        int step = 1;
        int[] dis = new int[n + 1];
        int[] sums = new int[n + 1];
        sums[1] = num[0];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                Set<Integer> neighbours = graph.get(cur);
                for (int next : neighbours) {
                    if (dis[next] == 0) {
                        dis[next] = step;
                        q.offer(next);
                        sums[next] = sums[cur] + num[next - 1];
                    }
                }
            }
            step++;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 1; i < dis.length; i++) {
            map.putIfAbsent(dis[i], new ArrayList<>());
            map.get(dis[i]).add(i);
        }
        step = 0;
        int ans = 0;
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            List<Integer> list = map.get(key);
            for (int sub : list) {
//                ans += num[sub];
//                step++;
            }
        }
        return 0;
    }

    // [0, 2, 3, 3, 5, 2, 1, 4, 2, 6, 3, 4, 5, 3, 1, 2, 6, 3, 1, 4, 4]
    // [0, 1, 0, 0, 3, 2, 0, 0, 2, 1, 1, 1, 0, 2, 3, 1, 1, 1, 0, 1, 0]
    //     1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0

    class PqNode {
        boolean[] visited;
        int curSum;
        int curCity;
        int steps;

        public PqNode(boolean[] visited, int curSum, int curCity, int steps) {
            this.visited = visited;
            this.curSum = curSum;
            this.curCity = curCity;
            this.steps = steps;
        }
    }

    public int getCountPq(int n, int k, int[] num, int[][] mp) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] m : mp) {
            graph.putIfAbsent(m[0], new HashSet<>());
            graph.get(m[0]).add(m[1]);
            graph.putIfAbsent(m[1], new HashSet<>());
            graph.get(m[1]).add(m[0]);
        }
        Queue<PqNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.curSum, a.curSum));
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        pq.add(new PqNode(visited, num[0], 1, k));
        int res = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            PqNode top = pq.poll();
            int curSum = top.curSum;
            int city = top.curCity;
            int steps = top.steps;
            if (steps == 0)
                res = Math.max(res, curSum);
            if (steps > 0) {
                Set<Integer> adj = graph.get(city);
                for (int a : adj) {
                    int newSum = curSum;
                    boolean[] newVisited = Arrays.copyOf(top.visited, n + 1);
                    if (!newVisited[a])
                        newSum += num[a - 1];
                    newVisited[a] = true;
                    pq.add(new PqNode(newVisited, newSum, a, steps - 1));
                }
            }
        }
        return res;
    }
}
