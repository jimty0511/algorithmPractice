package practice.lintcode;

// 591. Connecting Graph III
public class ConnectingGraphIII {

    private int[] parent;
    private int cnt;

    public ConnectingGraphIII(int n) {
        // initialize your data structure here.
        parent = new int[n + 1];
        cnt = n;
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
        }
    }

    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
            cnt--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return cnt;
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

}
