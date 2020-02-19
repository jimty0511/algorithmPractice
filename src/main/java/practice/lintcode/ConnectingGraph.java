package practice.lintcode;

// 589. Connecting Graph
public class ConnectingGraph {

    private int[] parent;

    /*
     * @param n: An integer
     */
    public ConnectingGraph(int n) {
        // do intialization if necessary
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB)
            parent[rootA] = rootB;
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        return rootA == rootB;
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
