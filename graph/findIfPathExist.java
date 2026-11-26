//  LC : 1971 Find if Path Exists in Graph, GFG
// Using Kahn's Algorithm
public boolean findIfPathExist(int n, int[][] edges, int src, int dest){
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for(int i = 0; i < n; i++){
        adj.add(new ArrayList<>());
    }

    for(int[] edge : edges){
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[n];
    Queue<Integer> q = new LinkedList<>();
    q.offer(src);
    visited[src] = true;

    while(!q.isEmpty()){
        int node = q.poll();
        if(node == dest){
            return true;
        }
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                q.offer(neighbor);
            }
        }
    }
    return false;
}