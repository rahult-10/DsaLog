//Perfect Squares

public int perfectSquare(int n) {
    return solve(n);
}

private int solve(int n) {
    if (n == 0) return 0;

    int min = Integer.MAX_VALUE;

    for (int i = 1; i * i <= n; i++) {
        min = Math.min(min, 1 + solve(n - i * i));
    }

    return min;
}

public void main(String[] args) {
    int n = 12;
    int result = perfectSquare(n);
    System.out.println(result);
}