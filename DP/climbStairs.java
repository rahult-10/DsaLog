//Using Recursion
// public int climbStairs(int n) {
//     if(n == 0)
//         return 1;
//     if(n < 0)
//         return 0;
//     return climbStairs(n-1) + climbStairs(n-2);
// }

// Using DP -> Memoization
public int memoization(int n, int[] dp){
    if (n == 0)
        return 1;
    if (n < 0)
        return 0;
    if (dp[n] != -1) {        return dp[n];
    }
    dp[n] = memoization(n-1,dp) + memoization(n - 2, dp);
    return dp[n];
}
public int climbStairs(int n){
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);
    return memoization(n, dp);
}

// Tabulation
public int tabulation(int n){
    int dp[] = new int [n+1];
    dp[0] = 1;
    for(int i = 1; i <= n; i++){
        if(i == 1){
            dp[i] = dp[i-1];
        } else{
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
    return dp[n];
}

public void main(String[] args) {
    int n = 44;
    System.out.println(climbStairs(n));
    System.out.println(tabulation(n));
}