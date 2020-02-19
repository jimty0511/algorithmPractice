package practice.lintcode;

// 1569. Social Network
public class SocialNetwork {
    /**
     * @param n: the person sum
     * @param a: the array a
     * @param b: the array b
     * @return: yes or no
     */
    public String socialNetwork(int n, int[] a, int[] b) {
        // Write your code here
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;
        for (int i = 0; i < a.length; i++) {
            int aP = find(parent, a[i]);
            int bP = find(parent, b[i]);
            if (parent[aP] != bP) {
                n--;
                parent[aP] = bP;
            }
        }
        return n <= 1 ? "yes" : "no";
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
