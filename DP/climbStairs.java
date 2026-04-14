//Using Recursion
public int climbStairs(int n) {
    if(n == 0)
        return 1;
    if(n < 0)
        return 0;
    return climbStairs(n-1) + climbStairs(n-2);
}

public void main(String[] args) {
    int n = 44;
    System.out.println(climbStairs(n));
}