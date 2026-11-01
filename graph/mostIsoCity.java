//LC 1334-> Find the City With the Smallest Number of Neighbors at a Threshold Distance
// gfg -> Most Isolated City
class mostIsoCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int inf = (int)1e9;
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], inf);
            dist[i][i] = 0;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int cntCity = Integer.MAX_VALUE;
        int cityNo = -1;

        for(int city = 0; city < n; city++){
            int count = 0;

            for(int adjCity = 0; adjCity < n; adjCity++){
                if(city != adjCity &&
                   dist[city][adjCity] <= distanceThreshold){
                    count++;
                }
            }

            if(count <= cntCity){
                cntCity = count;
                cityNo = city;
            }
        }

        return cityNo;
    }
}