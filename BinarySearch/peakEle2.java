//Find Peak Element 2
public int[] peakEle2(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int curr = mat[i][j];
            int up = (i > 0) ? mat[i - 1][j] : -1;
            int down = (i < m - 1) ? mat[i + 1][j] : -1;
            int left = (j > 0) ? mat[i][j - 1] : -1;
            int right = (j < n - 1) ? mat[i][j + 1] : -1;

            if (curr > up && curr > down && curr > left && curr > right) {
                return new int[]{i, j};
            }
        }
    }
    return new int[]{-1, -1};
}

public void main(String[] args) {
    int[][] mat = {{10,20,15}, {21,30,14}, {7,16,32}};
    int[] result = peakEle2(mat);
    System.out.println(result[0] + ", " + result[1]);
    
}
