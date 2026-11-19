// 947. Most Stones Removed with Same Row or Column

class Solution {

    int[] parent;
    int[] rank;
    
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) return;

        if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }
        else if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
        }
        else{
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n;i ++){
            parent[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i, j);
                }
            }
        }

        int components = 0;
        for(int i = 0; i < n; i++){
            if(find(i) == i){
                components++;
            }
        }
        return n - components;
    }
}