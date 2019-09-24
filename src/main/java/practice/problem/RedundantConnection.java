package practice.problem;

// 684. Redundant Connection
public class RedundantConnection {

    public int[] findRedundantConnectionThree(int[][] edges) {
        int[] parent = new int[1001];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        for (int[] e : edges) {
            int from = e[0], to = e[1];
            int find1 = findThree(from, parent);
            int find2 = findThree(to, parent);
            if (find1 == find2)
                return e;
            else
                parent[find1] = find2;
        }
        return new int[2];
    }

    private int findThree(int v, int[] parent) {
        while (v != parent[v]) {
            parent[v] = parent[parent[v]];
            v = parent[v];
        }
        return v;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        for (int[] e : edges) {
            int f = e[0], t = e[1];
            if (find(parent, f) == find(parent, t))
                return e;
            else
                parent[find(parent, f)] = find(parent, t);
        }
        return new int[2];
    }

    private int find(int[] parent, int f) {
        if (f != parent[f])
            parent[f] = find(parent, parent[f]);
        return parent[f];
    }

    public int[] findRedundantConnectionTwo(int[][] edges) {
        int[] parent = new int[1001];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (findTwo(from, parent) == findTwo(to, parent))
                return edge;
            union(from, to, parent);
        }
        return new int[2];
    }

    private int findTwo(int f, int[] parent) {
        while (f != parent[f]) {
            parent[f] = parent[parent[f]];
            f = parent[f];
        }
        return f;
    }

    private void union(int a, int b, int[] parent) {
        int aParent = findTwo(a, parent);
        int bParent = findTwo(b, parent);
        if (aParent == bParent)
            return;
        parent[aParent] = bParent;
    }
}
