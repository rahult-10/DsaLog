//Lc : 200 Number of Islands (using BFS And DFS)
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}

// OR ->
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] directions = {
            {1, 0}, {-1,0}, {0,1}, {0, -1}
        };
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';

                    while(!q.isEmpty()){
                        int[] cell = q.poll();
                        int row = cell[0];
                        int col = cell[1];

                        for(int[] dir : directions){
                            int nr = row + dir[0];
                            int nc = col + dir[1];

                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
