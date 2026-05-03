public int[] rowAndmaxOnes(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int idx = -1;
    int maxCnt = -1;
    for(int i=0; i < m; i++){
        int cntRow = 0;
        for(int j=0; j < n; j++){
            cntRow += mat[i][j];
        }
        if(cntRow > maxCnt){
            maxCnt = cntRow;
            idx = i;
        }
    }
    return new int[] {idx, maxCnt};
}

public void main(String[] args) {
    int[][] mat = {{0,1}, {1,0}};
    int[] result = rowAndmaxOnes(mat);
    System.out.println(Arrays.toString(result));
}