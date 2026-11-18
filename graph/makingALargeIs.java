// 827. Making A Large Island
// Maximum Connected with One Change

class DSU {
    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return;

        if (size[pu] < size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }

        parent[pv] = pu;
        size[pu] += size[pv];
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);

        int[][] dir = {
                { -1, 0 }, { 1, 0 },
                { 0, -1 }, { 0, 1 }
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;

                int id = i * n + j;

                for (int[] d : dir) {
                    int nr = i + d[0];
                    int nc = j + d[1];

                    if (nr >= 0 && nr < n &&
                            nc >= 0 && nc < n &&
                            grid[nr][nc] == 1) {

                        int nid = nr * n + nc;
                        dsu.union(id, nid);
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int root = dsu.find(i * n + j);
                    ans = Math.max(ans, dsu.size[root]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    continue;

                HashSet<Integer> set = new HashSet<>();
                int currSize = 1;

                for (int[] d : dir) {
                    int nr = i + d[0];
                    int nc = j + d[1];

                    if (nr >= 0 && nr < n &&
                            nc >= 0 && nc < n &&
                            grid[nr][nc] == 1) {

                        int root = dsu.find(nr * n + nc);

                        if (set.add(root)) {
                            currSize += dsu.size[root];
                        }
                    }
                }

                ans = Math.max(ans, currSize);
            }
        }

        return ans;
    }
}