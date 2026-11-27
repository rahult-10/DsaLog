// Gfg : Sum Of Dependencies
public int sumOfDependencies(int V, int[][] edges){
    int[] outDegree = new int[V];
    for(int[] e = edges){
        int u = e[0];
        outDegree[u]++
    }
    int sum = 0;
    for(int i = 0; i < V; i++){
        sum += outDegree[i];
    }
    return sum;
}