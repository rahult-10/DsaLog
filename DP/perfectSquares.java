public int perfectSquares(int n) {
    int[] memo = new int[n + 1];
    return solve(n, memo);
}

//DP -> Memoization 
private int solve(int n, int[] memo) {
    if (n == 0) return 0;

    if (memo[n] != 0) return memo[n];

    int min = Integer.MAX_VALUE;

    for (int i = 1; i * i <= n; i++) {
        min = Math.min(min, 1 + solve(n - i * i, memo));
    }

    memo[n] = min;
    return min;
}


// Using Tabulation
public int numSquares(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        dp[i] = Integer.MAX_VALUE;

        for (int j = 1; j * j <= i; j++) {
            dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
    }
    return dp[n];
}



public void main(String[] args) {
    int n = 56;
    int result = perfectSquares(n);
    System.out.println(result);
}