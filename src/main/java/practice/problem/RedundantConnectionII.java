package practice.problem;

// 685. Redundant Connection II
public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length];
        for (int i = 0; i < edges.length; i++)
            parent[i] = i;
        int[] candidate1 = null, candidate2 = null;
        for (int[] e : edges) {
            int parentx = find(parent, e[0] - 1), parenty = find(parent, e[1] - 1);
            if (parentx != parenty) {
                if (parenty != e[1] - 1)
                    candidate1 = e;
                else
                    parent[parenty] = parentx;
            } else {
                candidate2 = e;
            }
        }
        if (candidate1 == null)
            return candidate2;
        if (candidate2 == null)
            return candidate1;
        for (int[] e : edges) {
            if (e[1] == candidate1[1])
                return e;
        }
        return new int[2];
    }

    public int[] findRedundantDirectedConnectionTwo(int[][] edges) {
        int[] can1 = {-1, -1}, can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[]{edges[i][0], edges[i][1]};
                can1 = new int[]{parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++)
            parent[i] = i;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0)
                continue;
            int child = edges[i][1], father = edges[i][0];
            if (find(parent, father) == child) {
                if (can1[0] == -1)
                    return edges[i];
                return can1;
            }
            parent[child] = father;
        }
        return can2;
    }

    private int find(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
