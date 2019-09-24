package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 952. Largest Component Size by Common Factor
public class LargestComponentSizeByCommonFactor {
    public int largestComponentSize(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int a : A) {
            max = Math.max(a, max);
        }
        UnionFind unionFind = new UnionFind(max + 1);
        for (int a : A) {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    unionFind.union(a, i);
                    unionFind.union(a, a / i);
                }
            }
        }
        int res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            int parent = unionFind.find(a);
            map.put(parent, map.getOrDefault(parent, 0) + 1);
            res = Math.max(res, map.get(parent));
        }
        return res;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
        }

        public void union(int x, int y) {
            parent[find(x)] = parent[find(y)];
        }

        public int find(int v) {
            while (v != parent[v]) {
                parent[v] = parent[parent[v]];
                v = parent[v];
            }
            return v;
        }
    }
}
