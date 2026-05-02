//Search In 2D Matrix 2

public boolean searchInMatrix2(int[][] matrix, int target) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

    int m = matrix.length;
    int n = matrix[0].length;

    int row = 0;
    int col = n - 1;

    while(row < m && col >= 0) {
        if(matrix[row][col] == target) {
            return true;
        } else if(matrix[row][col] > target) {
            col--;
        } else {
            row++;
        }
    }

    return false;
}

public void main(String[] args) {
    int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    int target = 3;
    boolean result = searchInMatrix2(matrix, target);
    System.out.println(result);
}
