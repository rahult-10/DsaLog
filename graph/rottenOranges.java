// LC : 994. Rotting Oranges (Using BFS)

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int minutes = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {1, 0}, {-1,0}, {0,1}, {0, -1}
        };

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {

                int[] current = q.poll();

                int row = current[0];
                int col = current[1];

                for (int[] dir : directions) {

                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nc >= 0 &&
                        nr < m && nc < n &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;
                        rotted = true;

                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            if (rotted) {
                minutes++;
            }
        }
        return fresh == 0? minutes : -1;
    }
}