// kruskal's with DSU
//Lc -> 1631. Path With Minimum Effort, gfg

class Solution {

    class Edge {
        int u, v, wt;
        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    int[] parent;
    int[] size;

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int u , int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int total = m * n;
        parent = new int[total];
        size = new int[total];

        for(int i = 0; i < total; i++){
            parent[i] = i;
            size[i] = 1;
        }

        List<Edge> edges = new ArrayList<>();

        int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int u = i * n + j;

                for (int[] dir : directions) {

                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        int v = ni * n + nj;
                        int wt = Math.abs(heights[i][j] - heights[ni][nj]);
                        edges.add(new Edge(u, v, wt));
                    }
                }
            }
        }

        edges.sort((a, b) -> Integer.compare(a.wt, b.wt));

        for (Edge edge : edges) {
            union(edge.u, edge.v);
            if (find(0) == find(total - 1)) {
                return edge.wt;
            }
        }

        return 0;
    }
}