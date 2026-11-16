// Solution 1 -> Kruskal's Algo + DSU
// LC 1584. Min Cost to Connect All Points

class Solution {

    static class Edge {
        int point1;
        int point2;
        int distance;

        Edge(int point1, int point2, int distance) {
            this.point1 = point1;
            this.point2 = point2;
            this.distance = distance;
        }
    }

    private int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private class DisjointSet {
        int[] parent;
        int[] size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int node) {
            if (parent[node] == node) {
                return node;
            }

            return parent[node] = findParent(parent[node]);
        }

        boolean union(int node1, int node2) {
            int root1 = findParent(node1);
            int root2 = findParent(node2);

            if (root1 == root2) {
                return false;
            }

            if (size[root1] >= size[root2]) {
                parent[root2] = root1;
                size[root1] += size[root2];
            } else {
                parent[root1] = root2;
                size[root2] += size[root1];
            }

            return true;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int totalCost = 0;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.distance, b.distance));

        // Generate all possible edges
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = calculateManhattanDistance(
                        points[i][0], points[i][1],
                        points[j][0], points[j][1]);

                minHeap.offer(new Edge(i, j, distance));
            }
        }

        DisjointSet dsu = new DisjointSet(n);
        int edgesUsed = 0;

        // Apply Kruskal's algorithm
        while (!minHeap.isEmpty() && edgesUsed < n - 1) {
            Edge currentEdge = minHeap.poll();

            if (dsu.union(currentEdge.point1, currentEdge.point2)) {
                totalCost += currentEdge.distance;
                edgesUsed++;
            }
        }

        return totalCost;
    }
}