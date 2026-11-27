// LC : 802. Find Eventual Safe States
// GFG : Safe States
//  Using DFS
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(dfs(i, graph, state)){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    public boolean dfs(int node, int[][] graph, int[] state){
        if(state[node] == 1){
            return false;
        }
        if(state[node] == 2){
            return true;
        }
        state[node] = 1;
        for(int neighbor : graph[node]){
            if(!dfs(neighbor, graph, state)){
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}

// OR -> BFS + Topo
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Original edge: i -> neighbour
        // Reversed edge: neighbour -> i
        for (int i = 0; i < n; i++) {
            for (int neighbour : graph[i]) {
                reverseGraph.get(neighbour).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);
            for(int neighbour : reverseGraph.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}