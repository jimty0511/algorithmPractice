package practice.problem;

// 200. Number of Islands
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslandsHelper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void numIslandsHelper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        numIslandsHelper(grid, i + 1, j);
        numIslandsHelper(grid, i - 1, j);
        numIslandsHelper(grid, i, j + 1);
        numIslandsHelper(grid, i, j - 1);
    }

    public int numIslandsUf(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;
        int m = grid.length, n = grid[0].length;
        int[] parent = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int id = i * n + j;
                    parent[id] = id;
                    count++;
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : dirs) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1') {
                            int id1 = i * n + j;
                            int id2 = x * n + y;
                            int id1Res = find(parent, id1);
                            int id2Res = find(parent, id2);
                            if (id1Res != id2Res) {
                                parent[id1Res] = id2Res;
                                count--;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private int find(int[] parent, int id) {
        while (id != parent[id])
            id = parent[id];
        return id;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslandsUfTwo(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        UnionFind uf = new UnionFind(grid);
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                            int id1 = i * n + j;
                            int id2 = x * n + y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        int[] parent;
        int m, n;
        int count = 0;

        UnionFind(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        parent[id] = id;
                        count++;
                    }
                }
            }
        }

        private int find(int val) {
            while (val != parent[val]) {
                parent[val] = parent[parent[val]];
                val = parent[val];
            }
            return val;
        }

        public void union(int a, int b) {
            int find1 = find(a);
            int find2 = find(b);
            if (find1 != find2) {
                parent[find1] = find2;
                count--;
            }
        }
    }
}
