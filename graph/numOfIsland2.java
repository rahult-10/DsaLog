// GFG : Count Islands After Every Operation
//LC : Number of Islands 2

class Solution {
	
	int[] parent;
	int[] rank;
	
	int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	boolean union(int u, int v) {
		int pu = find(u);
		int pv = find(v);
		
		if (pu == pv)
			return false;
		
		if (rank[pu] < rank[pv]) {
			parent[pu] = pv;
		}
		else if (rank[pu] > rank[pv]) {
			parent[pv] = pu;
		}
		else {
			parent[pv] = pu;
			rank[pu]++;
		}
		return true;
	}
	
	public ArrayList<Integer> numOfIslands(int n, int m, int[][] operators) {
		// Your code here
		parent = new int[n*m];
		rank = new int[n*m];
		Arrays.fill(parent, -1);
		
		ArrayList<Integer> result = new ArrayList<>();
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int isLands = 0;
		for (int[] op : operators) {
			int row = op[0];
			int col = op[1];
			
			int node = row * m + col;
			if (parent[node] != -1) {
				result.add(isLands);
				continue;
			}
			
			parent[node] = node;
			isLands++;
			
			for (int i = 0; i <4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
					continue;
				}
				
				int neighbor = nr * m + nc;
				
				if (parent[neighbor] != -1) {
					
					if (union(node, neighbor)) {
						isLands--;
					}
				}
			}
			
			result.add(isLands);
		}
		return result;
	}
}

