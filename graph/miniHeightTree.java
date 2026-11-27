// 310. Minimum Height Trees
// Topological Trimming with BFS
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return Arrays.asList(0);
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] degree = new int[n];
        for(int i = 0; i < n; i++){
            degree[i] = adj.get(i).size();
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1){
                q.offer(i);
            }
        }

        int remainingNode = n;
        while(remainingNode > 2){
            int size = q.size();
            remainingNode -= size;
            for(int i = 0; i < size; i++){
                int leaf = q.poll();
                for(int neighbor : adj.get(leaf)){
                    degree[neighbor]--;
                    if(degree[neighbor] == 1){
                        q.offer(neighbor);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }
}