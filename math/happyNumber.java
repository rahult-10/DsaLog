public boolean happyNumber(int n){
    int slow = square(n);
    int fast = square(square(n));
    while(slow != fast){
        slow = square(slow);
        fast = square(square(fast));
        if(slow == 1 || fast == 1){
            return true;
        }
    }
    return slow == 1;
}

public int square(int n){
    int ans = 0;
    while(n > 0){
        int ld = n%10;  // ld -> last digit
        ans += ld * ld;
        n /= 10;
    }
    return ans;
}


// Or  -> 0ms optimized
public boolean isHappy(int n){
    if(n==1) return true;
    if(n==4) return false;

    int ans = 0;
    while(n>0){
        int ld = n%10;
        ans += ld*ld;
        n /= 10;
    }
    return isHappy(ans);
}



public void main() {
    int n = 19;
    boolean result = happyNumber(n);
    boolean res  = isHappy(n);
    System.out.println(result);
    System.out.println(res);
}