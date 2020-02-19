package practice.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 805. Maximum Association Set
public class MaximumAssociationSet {

    class UnionFind {
        int[] size, parent;

        public UnionFind(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
        }
    }

    /**
     * @param ListA: The relation between ListB's books
     * @param ListB: The relation between ListA's books
     * @return: The answer
     */
    public List<String> maximumAssociationSet(String[] ListA, String[] ListB) {
        // Write your code here
        List<String> res = new ArrayList<>();
        Map<String, Integer> nameToId = new HashMap<>();
        Map<Integer, String> idToName = new HashMap<>();
        for (int i = 0; i < ListA.length; i++) {
            if (!nameToId.containsKey(ListA[i])) {
                nameToId.put(ListA[i], i);
                idToName.put(i, ListA[i]);
            }
            if (!nameToId.containsKey(ListB[i])) {
                nameToId.put(ListB[i], ListA.length + i);
                idToName.put(ListA.length + i, ListB[i]);
            }
        }
        int n = ListA.length + ListB.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < ListA.length; i++)
            uf.union(nameToId.get(ListA[i]), nameToId.get(ListB[i]));
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (uf.size[i] > max) {
                max = uf.size[i];
                idx = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == idx)
                res.add(idToName.get(i));
        }
        return res;
    }
}
